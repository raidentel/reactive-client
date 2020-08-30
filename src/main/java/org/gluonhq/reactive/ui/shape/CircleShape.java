package org.gluonhq.reactive.ui.shape;

import javafx.scene.shape.Circle;
import org.gluonhq.reactive.BasicView;

public class CircleShape extends BaseShape {

    public CircleShape(BasicView view) {
        super( view, () ->  new Circle( view.getRandomX(), view.getRandomY(), 50 ));
    }

}