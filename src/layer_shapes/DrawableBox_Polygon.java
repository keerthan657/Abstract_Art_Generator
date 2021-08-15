package layer_shapes;

import javafx.scene.Group;

import functionalities.drawable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class DrawableBox_Polygon extends DrawableBox
{
    int complexity, size;
    String style;

    public DrawableBox_Polygon(int complexity, int size, String style)
    {
        this.complexity = complexity;
        this.size = size;
        this.style = style;
    }

    public void draw(Group layout)
    {
        if(style.equals("Chaotic")) {
            Polygon[] polygon = new Polygon[(int) (complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                polygon[i] = generatePolygon(100, 100, (int) (Math.random() * 800), (int) (Math.random() * 600));
                layout.getChildren().add(polygon[i]);
            }
        }
        else {
            System.out.println("Layer info blank!! - DrawableBox_Polygon");
        }
    }

    public Polygon generatePolygon(int xSpan, int ySpan, int xRef, int yRef)
    {
        Polygon quad = new Polygon();

        double p1X, p1Y, p2X, p2Y, p3X, p3Y, p4X, p4Y;

        p1X = Math.random()*xSpan;
        p2X = Math.random()*xSpan;
        p3X = Math.random()*xSpan;
        p4X = Math.random()*xSpan;

        p1Y = Math.random()*ySpan;
        p2Y = Math.random()*ySpan;
        p3Y = Math.random()*ySpan;
        p4Y = Math.random()*ySpan;

        quad.getPoints().addAll(new Double[]{
                p1X+xRef, p1Y+yRef,
                p2X+xRef, p2Y+yRef,
                p3X+xRef, p3Y+yRef,
                p4X+xRef, p4Y+yRef,
        });


        Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];
        quad.setFill(color);

        return quad;
    }
}