package layer_shapes;

import javafx.scene.Group;
import javafx.scene.shape.Line;

import functionalities.drawable;

public class DrawableLine
{
    int complexity, size;
    String style;

    public DrawableLine(int complexity, int size, String style)
    {
        this.complexity = complexity;
        this.size = size;
        this.style = style;
    }

    public void draw(Group layout)
    {
        if(style.equals("Chaotic")) {
            Line[] line = new Line[(int)(complexity / 2)];

            for(int i=0; i<(int)(complexity / 2); i++) {
                double xStart, xEnd;
                double yStart, yEnd;

                // Chaotic
                xStart = (Math.random() * 800);
                xEnd =  (Math.random() * 800);
                yStart = (Math.random() * 600);
                yEnd =  (Math.random() * 600);

                line[i] = new Line(xStart, yStart, xEnd, yEnd);
                line[i].setStroke(drawable.myColors[(int)(Math.random()*drawable.myColors.length)]);

                layout.getChildren().add(line[i]);
            }
        }
        else if(style.equals("Horizontal")) {
            // Horizontal
            Line[] line = new Line[(int) (complexity / 2)];

            for (int i = 0; i < (int) (complexity / 2); i++) {
                double xStart, xEnd;
                double yStart, yEnd;

                int noOfRows = 5;
                int spacing = (int) (600 / noOfRows);

                xStart = 0;
                xEnd = 800;
                yStart = yEnd = (spacing * i) % 600;

                line[i] = new Line(xStart, yStart, xEnd, yEnd);
                line[i].setStroke(drawable.myColors[(int) (Math.random() * drawable.myColors.length)]);

                line[i].setRotate((Math.random() * 10) - 5);
                line[i].setTranslateX(Math.random() * 5);
                line[i].setTranslateY(Math.random() * 5);

                layout.getChildren().add(line[i]);
            }
        }
        else if(style.equals("Vertical")) {
            // Vertical
            Line[] line = new Line[(int) (complexity / 2)];

            for (int i = 0; i < (int) (complexity / 2); i++) {
                double xStart, xEnd;
                double yStart, yEnd;

                int noOfCols = 5;
                int spacing = (int) (600 / noOfCols);

                xStart = xEnd = (spacing * i) % 800;
                yStart = 0;
                yEnd = 600;

                line[i] = new Line(xStart, yStart, xEnd, yEnd);
                line[i].setStroke(drawable.myColors[(int) (Math.random() * drawable.myColors.length)]);

                line[i].setRotate((Math.random() * 10) - 5);
                line[i].setTranslateX(Math.random() * 5);
                line[i].setTranslateY(Math.random() * 5);

                layout.getChildren().add(line[i]);
            }
        }
        else if(style.equals("Cornered")) {
            // Cornered
            Line[] line = new Line[(int) (complexity / 2)];

            for (int i = 0; i < (int) (complexity / 2); i++) {
                double xStart, xEnd;
                double yStart, yEnd;

                if (Math.random() > 0.75) {
                    xStart = 0;
                    yStart = 0;
                    xEnd = (int) (Math.random() * 200);
                    yEnd = (int) (Math.random() * 200);
                } else if (Math.random() > 0.50) {
                    xStart = 800;
                    yStart = 0;
                    xEnd = 600 + (int) (Math.random() * 200);
                    yEnd = (int) (Math.random() * 200);
                } else if (Math.random() > 0.25) {
                    xStart = 0;
                    yStart = 600;
                    xEnd = (int) (Math.random() * 200);
                    yEnd = 400 + (int) (Math.random() * 200);
                } else {
                    xStart = 800;
                    yStart = 600;
                    xEnd = 600 + (int) (Math.random() * 200);
                    yEnd = 400 + (int) (Math.random() * 200);
                }

                line[i] = new Line(xStart, yStart, xEnd, yEnd);
                line[i].setStroke(drawable.myColors[(int) (Math.random() * drawable.myColors.length)]);

                line[i].setRotate((Math.random() * 10) - 5);
                line[i].setTranslateX(Math.random() * 5);
                line[i].setTranslateY(Math.random() * 5);

                layout.getChildren().add(line[i]);
            }
        }
        else {
            System.out.println("Layer info not provided, setting to blank!!");
        }
    }
}