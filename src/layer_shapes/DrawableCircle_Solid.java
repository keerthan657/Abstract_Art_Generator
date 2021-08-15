package layer_shapes;

import functionalities.drawable;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

public class DrawableCircle_Solid extends DrawableCircle
{
    int complexity, size;
    String style;

    public DrawableCircle_Solid(int complexity, int size, String style)
    {
        this.complexity = complexity;
        this.size = size;
        this.style = style;
    }

    public void draw(Group layout)
    {
        Circle[] circle = new Circle[(int)(complexity / 2)];

        if(style.equals("Chaotic")) {
            for (int i = 0; i < (int) (complexity / 2); i++) {
                xPos = (int) (Math.random() * 800);
                yPos = (int) (Math.random() * 600);
                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();
                circle[i].setCenterX(xPos);
                circle[i].setCenterY(yPos);
                circle[i].setFill(color);
                circle[i].setRadius((int) (size * 3));
                layout.getChildren().add(circle[i]);
            }
        }
        else if(style.equals("Horizontal")) {
            //System.out.println("Circle-horizontal = debug<>");
            int noOfRows = (int)(complexity/10) + 2;
            int spacing = (int)(600 / noOfRows);

            yPos = 0;
            for(int i=0; i < (int) (complexity / 2); i++) {
                xPos = (int) (Math.random() * 800);
                yPos = (yPos + spacing) % 600;
                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();
                circle[i].setCenterX(xPos);
                circle[i].setCenterY(yPos + (spacing/2));
                circle[i].setFill(color);
                circle[i].setRadius((int) (size * 3));
                layout.getChildren().add(circle[i]);
            }
        }
        else if(style.equals("Vertical")) {
            //System.out.println("Circle-vertical = debug<>");
            int noOfCols = (int)(complexity/10) + 2;
            int spacing = (int)(800 / noOfCols);

            yPos = 0;
            for(int i=0; i < (int) (complexity / 2); i++) {
                xPos = (xPos + spacing) % 800;
                yPos = (int) (Math.random() * 600);
                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();
                circle[i].setCenterX(xPos + (spacing/2));
                circle[i].setCenterY(yPos);
                circle[i].setFill(color);
                circle[i].setRadius((int) (size * 3));
                layout.getChildren().add(circle[i]);
            }
        }
        else if(style.equals("Cornered")) {
            // Cornered means X values are randomly picked from (0,200) or (600,800)
            // and Y values are randomly picked from (0,200) or (400,600)
            for (int i = 0; i < (int) (complexity / 2); i++) {
                xPos = (int) (Math.random() * 200);
                yPos = (int) (Math.random() * 200);

                if(Math.random()>0.5f) {
                    // range from 600 to 800
                    xPos += 600;
                }
                if(Math.random()>0.5f) {
                    // range from 400 to 600
                    yPos += 400;
                }

                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();
                circle[i].setCenterX(xPos);
                circle[i].setCenterY(yPos);
                circle[i].setFill(color);
                circle[i].setRadius(size * 3);
                layout.getChildren().add(circle[i]);
            }
        }
        else {
            System.out.println("Layer info not provided, setting to blank!!");
        }
    }
}
