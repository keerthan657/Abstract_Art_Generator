package layer_shapes;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import functionalities.drawable;

public class DrawableCircle_Ring extends DrawableCircle
{
    int complexity, size;
    String style;

    public DrawableCircle_Ring(int complexity, int size, String style)
    {
        this.complexity = complexity;
        this.size = size;
        this.style = style;
    }

    public void draw(Group layout)
    {
        Circle[] circle = new Circle[(int)(complexity / 2) * 2];

        if(style.equals("Chaotic")) {
            for(int i=0; i<(2*(int)(complexity / 2)); i+=2)
            {
                xPos = (int)(Math.random()*800);
                yPos = (int)(Math.random()*600);
                color = drawable.myColors[(int)(Math.random()*drawable.myColors.length)];

                // Drawing the solid circle
                circle[i] = new Circle();
                circle[i].setCenterX(xPos);
                circle[i].setCenterY(yPos);
                circle[i].setFill(color);
                circle[i].setRadius((int)(size * 3));

                // Now drawing white inner circle (should match background color)
                circle[i+1] = new Circle();
                circle[i+1].setCenterX(xPos);
                circle[i+1].setCenterY(yPos);
                circle[i+1].setFill(Color.WHITE);
                circle[i+1].setRadius((int)(size * 2));

                Shape donutShape = Shape.subtract(circle[i], circle[i+1]);
                donutShape.setFill(color);
                layout.getChildren().add(donutShape);
            }
        }
        else if(style.equals("Horizontal")) {
            //System.out.println("Circle-horizontal = debug<>");
            int noOfRows = (int)(complexity/10) + 2;
            int spacing = (int)(600 / noOfRows);

            yPos = 0;
            for(int i=0; i <(2*(int)(complexity / 2)); i+=2) {
                xPos = (int) (Math.random() * 800);
                yPos = (yPos + spacing) % 600;
                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();
                circle[i].setCenterX(xPos);
                circle[i].setCenterY(yPos + (spacing/2));
                circle[i].setFill(color);
                circle[i].setRadius((int) (size * 3));

                circle[i+1] = new Circle();
                circle[i+1].setCenterX(xPos);
                circle[i+1].setCenterY(yPos + (spacing/2));
                circle[i+1].setFill(Color.WHITE);
                circle[i+1].setRadius((int)(size * 2));

                Shape donutShape = Shape.subtract(circle[i], circle[i+1]);
                donutShape.setFill(color);
                layout.getChildren().add(donutShape);
            }
        }
        else if(style.equals("Vertical")) {
            //System.out.println("Circle-vertical = debug<>");
            int noOfCols = (int)(complexity/10) + 2;
            int spacing = (int)(800 / noOfCols);

            yPos = 0;
            for(int i=0; i < (2*(int) (complexity / 2)); i+=2) {
                xPos = (xPos + spacing) % 800;
                yPos = (int) (Math.random() * 600);
                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();
                circle[i].setCenterX(xPos + (spacing/2));
                circle[i].setCenterY(yPos);
                circle[i].setFill(color);
                circle[i].setRadius((int) (size * 3));

                circle[i+1] = new Circle();
                circle[i+1].setCenterX(xPos + (spacing/2));
                circle[i+1].setCenterY(yPos);
                circle[i+1].setFill(Color.WHITE);
                circle[i+1].setRadius((int)(size * 2));

                Shape donutShape = Shape.subtract(circle[i], circle[i+1]);
                donutShape.setFill(color);
                layout.getChildren().add(donutShape);
            }
        }
        else if(style.equals("Cornered")) {
            // Cornered means X values are randomly picked from (0,200) or (600,800)
            // and Y values are randomly picked from (0,200) or (400,600)
            for (int i = 0; i <(2* (int) (complexity / 2)); i+=2) {
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

                circle[i+1] = new Circle();
                circle[i+1].setCenterX(xPos);
                circle[i+1].setCenterY(yPos);
                circle[i+1].setFill(Color.WHITE);
                circle[i+1].setRadius((int)(size * 2));

                Shape donutShape = Shape.subtract(circle[i], circle[i+1]);
                donutShape.setFill(color);
                layout.getChildren().add(donutShape);
            }
        }
        else {
            System.out.println("Layer info not provided, setting to blank!!");
        }
    }
}
