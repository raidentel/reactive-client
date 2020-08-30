package org.gluonhq.reactive.ui.shape;

import javafx.scene.shape.Rectangle;
import org.gluonhq.reactive.BasicView;
import org.gluonhq.reactive.controller.MainController;

public class RectShape extends BaseShape {

    public RectShape(BasicView view) {
        super(view, () -> new Rectangle(view.getRandomX(), view.getRandomY(), 100, 100));
    }
}