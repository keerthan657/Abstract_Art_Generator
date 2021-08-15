package layer_shapes;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

import functionalities.drawable;

public class DrawableBox_Rectangle extends DrawableBox
{
    int complexity, size;
    String style;

    public DrawableBox_Rectangle(int complexity, int size, String style)
    {
        this.complexity = complexity;
        this.size = size;
        this.style = style;
    }

    public void draw(Group layout)
    {
        Rectangle[] rectangle = new Rectangle[(int)(complexity / 2)];

        if(style.equals("Chaotic")) {
            for (int i = 0; i < (int) (complexity / 2); i++) {
                xPos = (int) (Math.random() * 800);
                yPos = (int) (Math.random() * 600);
                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                rectangle[i] = new Rectangle();
                rectangle[i].setX(xPos);
                rectangle[i].setY(yPos);
                rectangle[i].setFill(color);
                rectangle[i].setWidth(size * (int)(Math.random() * 5));
                rectangle[i].setHeight(size * (int)(Math.random() * 5));
                layout.getChildren().add(rectangle[i]);
            }
        }
        else if(style.equals("Horizontal")) {
            int noOfRows = (int)(complexity/10) + 2;
            int spacing = (int)(600 / noOfRows);

            yPos = 0;
            for(int i=0; i < (int) (complexity / 2); i++) {
                xPos = (int) (Math.random() * 800);
                yPos = (yPos + spacing) % 600;
                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                rectangle[i] = new Rectangle();
                rectangle[i].setX(xPos);
                rectangle[i].setY(yPos + (spacing/2));
                rectangle[i].setFill(color);
                rectangle[i].setWidth(size * (int)(Math.random() * 5));
                rectangle[i].setHeight(size * (int)(Math.random() * 5));
                layout.getChildren().add(rectangle[i]);
            }
        }
        else if(style.equals("Vertical")) {
            int noOfCols = (int)(complexity/10) + 2;
            int spacing = (int)(800 / noOfCols);

            yPos = 0;
            for(int i=0; i < (int) (complexity / 2); i++) {
                xPos = (xPos + spacing) % 800;
                yPos = (int) (Math.random() * 600);
                color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                rectangle[i] = new Rectangle();
                rectangle[i].setX(xPos + (spacing/2));
                rectangle[i].setY(yPos);
                rectangle[i].setFill(color);
                rectangle[i].setWidth(size * (int)(Math.random() * 5));
                rectangle[i].setHeight(size * (int)(Math.random() * 5));
                layout.getChildren().add(rectangle[i]);
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

                rectangle[i] = new Rectangle();
                rectangle[i].setX(xPos);
                rectangle[i].setY(yPos);
                rectangle[i].setFill(color);
                rectangle[i].setWidth(size * (int)(Math.random() * 5));
                rectangle[i].setHeight(size * (int)(Math.random() * 5));
                layout.getChildren().add(rectangle[i]);
            }
        }
        else {
            System.out.println("Layer info blank!! - DrawableBox_Square");
        }
    }
}