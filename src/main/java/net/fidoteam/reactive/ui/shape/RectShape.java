package net.fidoteam.reactive.ui.shape;

import javafx.scene.shape.Rectangle;
import net.fidoteam.reactive.view.BasicView;

public class RectShape extends BaseShape {

    public RectShape(BasicView view) {
        super(view, () -> new Rectangle(view.getRandomX(), view.getRandomY(), 100, 100));
    }
}