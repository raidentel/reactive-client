package net.fidoteam.reactive.view;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import lombok.Data;
import net.fidoteam.reactive.controller.MainController;
import net.fidoteam.reactive.ui.shape.CircleShape;
import net.fidoteam.reactive.ui.shape.RectShape;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

@Data
public class BasicView extends View implements Supplier<View> {

    // injected by FXMLLoader:
    @FXML
    private TextField someTextField;

    @Autowired
    private MainController controller;


    private Pane shapeCanvas = new Pane();
    private ObjectProperty<Shape> selectedShapeProperty = new SimpleObjectProperty<>(null);

    public BasicView() {
        setCenter(shapeCanvas);
        // clear selection on canvas click
        JavaFxObservable.eventsOf(shapeCanvas, MouseEvent.MOUSE_CLICKED)
                .subscribe(e -> clearSelection());


    }

    @Override
    protected void updateAppBar(AppBar appBar) {


        Button displayButton = MaterialDesignIcon.VOICEMAIL.button(this::displayCats);

        Button removeButton = MaterialDesignIcon.DELETE.button(this::removeSelected);
        removeButton.setDisable(true);

        selectedShapeProperty.addListener((o, oldShape, newShape) -> {
            updateShapeAppearance(oldShape, false);
            updateShapeAppearance(newShape, true);
            removeButton.setDisable(newShape == null);
        });

        appBar.setTitleText("Reactive Sample");
        appBar.getActionItems().add(MaterialDesignIcon.ADD_BOX.button(this::addBox));
        appBar.getActionItems().add(MaterialDesignIcon.ADD_CIRCLE.button(this::addCircle));
        appBar.getActionItems().add(removeButton);
        appBar.getActionItems().add(displayButton);
        appBar.getActionItems().add(MaterialDesignIcon.CLEAR_ALL.button(this::clearAllShapes));
    }

    private static void updateShapeAppearance(Shape shape, boolean selected) {
        if (shape == null) return;

        shape.setFill(selected ? Color.LIGHTGREEN : Color.LIGHTBLUE);
        shape.setStroke(Color.DARKGRAY);
        shape.setStrokeWidth(2.5);

        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(3.0);
        shadow.setOffsetX(3.0);
        shadow.setColor(Color.GRAY);
        shape.setEffect(shadow);
    }

    private void displayCats(ActionEvent event) {
        MobileApplication.getInstance().switchView("SPLASH_VIEW");
    }

    private void addBox(ActionEvent event) {
        shapeCanvas.getChildren().add(new RectShape(this).getRootShape());
    }

    private void addCircle(ActionEvent event) {
        shapeCanvas.getChildren().add(new CircleShape(this).getRootShape());
    }

    private void removeSelected(ActionEvent event) {

        Optional.ofNullable(selectedShapeProperty.get())
                .ifPresent(node -> {
                    clearSelection();
                    shapeCanvas.getChildren().remove(node);
                });

    }

    private void clearAllShapes(ActionEvent event) {
        shapeCanvas.getChildren().clear();
        clearSelection();
    }

    private void clearSelection() {
        select(null);
    }

    public void select(Shape shape) {
        if (shape != selectedShapeProperty.get()) {
            selectedShapeProperty.set(shape);
        }
    }

    private Random random = new Random();

    public double getRandomX() {
        return random.nextDouble() * this.getWidth();
    }

    public double getRandomY() {
        return random.nextDouble() * this.getHeight();
    }


    @Override
    public View get() {
        return this;
    }
}












