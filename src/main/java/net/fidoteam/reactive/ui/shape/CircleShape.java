package net.fidoteam.reactive.ui.shape;

import javafx.scene.shape.Circle;
import net.fidoteam.reactive.view.BasicView;

public class CircleShape extends BaseShape {

    public CircleShape(BasicView view) {
        super( view, () ->  new Circle( view.getRandomX(), view.getRandomY(), 50 ));
    }

}