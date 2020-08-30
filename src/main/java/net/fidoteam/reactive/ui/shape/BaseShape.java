package net.fidoteam.reactive.ui.shape;

import io.reactivex.disposables.Disposable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import net.fidoteam.reactive.view.BasicView;

import java.util.function.Supplier;

public class BaseShape {

    private Shape rootShape;
    private Point2D delta;
    private BasicView view;

    public BaseShape( BasicView view, Supplier<Shape> buildRootShape) {

        this.view = view;
        rootShape = buildRootShape.get();
        view.select(rootShape);

        // select shape on click
        Disposable disposable = JavaFxObservable.eventsOf(rootShape, MouseEvent.MOUSE_CLICKED)
                .subscribe( e -> {
                    view.select(rootShape);
                    e.consume();
                });


        // dispose "listeners" when shape is removed from the scene
        JavaFxObservable.changesOf(rootShape.sceneProperty())
                .filter( scene -> scene == null )
                .subscribe( s -> disposable.dispose());


        // calculate delta between shape location and initial mouse position on mouse pressed
        JavaFxObservable
                .eventsOf( rootShape, MouseEvent.MOUSE_PRESSED )
                .map( e -> new Point2D( e.getSceneX(), e.getSceneY()))
                .subscribe( p -> {
                    view.select(rootShape);
                    Bounds bounds = rootShape.localToScene(rootShape.getLayoutBounds());
                    delta =  p.subtract( new Point2D(bounds.getMinX(), bounds.getMinY()) );
                });

        // User current mouse position and delta to recalculate and set new shape location on mouse dragged
        JavaFxObservable
                .eventsOf( rootShape, MouseDragEvent.MOUSE_DRAGGED )
                .map( e -> rootShape.sceneToLocal(e.getSceneX() - delta.getX(),  e.getSceneY() - delta.getY()))
                .map( p -> rootShape.localToParent(p))
                .subscribe( p -> rootShape.relocate(  p.getX(), p.getY()));

    }

    public Shape getRootShape() {
        return rootShape;
    }

}