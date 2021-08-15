package layer_shapes;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class DrawableBox
{
    int xPos;
    int yPos;
    Color color;

    public void draw(Group layout)
    {
        // this is overridden in child classes
        System.out.println("Parent method calls draw");
    }
}