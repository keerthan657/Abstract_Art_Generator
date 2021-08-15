package others;

import functionalities.drawable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Animator// extends Thread
{
    Group layout;
    layer layer1;
    layer layer2;

    public Animator(Group layout, layer layer1, layer layer2)
    {
        this.layout = layout;
        this.layer1 = layer1;
        this.layer2 = layer2;
    }

    public void run()
    {
        if(layer1.getShape()=="Rectangle")
        {
            int complexity = layer1.getComplexity();

            int[] xPositions = new int[(int)(complexity / 2)];
            int[] yPositions = new int[(int)(complexity / 2)];

            Rectangle[] rectangle = new Rectangle[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                    int xPos = (int) (Math.random() * 800);
                    int yPos = (int) (Math.random() * 600);
                    Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                    rectangle[i] = new Rectangle();

                    translateTransition[i] = new TranslateTransition();
                    translateTransition[i].setDuration(Duration.millis(5000));
                    translateTransition[i].setNode(rectangle[i]);
                    translateTransition[i].setByX((int)(Math.random()*100)-50);
                    translateTransition[i].setByY((int)(Math.random()*100)-50);
                    translateTransition[i].setCycleCount((int)(Math.random()*50));
                    translateTransition[i].setAutoReverse(true);
                    translateTransition[i].play();

                    rectangle[i].setX(xPos);
                    xPositions[i] = xPos;
                    rectangle[i].setY(yPos);
                    yPositions[i] = yPos;
                    rectangle[i].setFill(color);
                    rectangle[i].setWidth((int) (Math.random() * layer1.getSize()));
                    rectangle[i].setHeight((int) (Math.random() * layer1.getSize()));
                    layout.getChildren().add(rectangle[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer1.getShape()=="Circle")
        {
            int complexity = layer1.getComplexity();

            int xPositions[] = new int[(int)(complexity / 2)];
            int yPositions[] = new int[(int)(complexity / 2)];

            Circle[] circle = new Circle[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                int xPos = (int) (Math.random() * 800);
                int yPos = (int) (Math.random() * 600);
                Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(circle[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                circle[i].setCenterX(xPos);
                xPositions[i] = xPos;
                circle[i].setCenterY(yPos);
                yPositions[i] = yPos;
                circle[i].setFill(color);
                circle[i].setRadius((int) (layer1.getSize() * 3));
                layout.getChildren().add(circle[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer1.getShape()=="Ring")
        {
            int complexity = layer1.getComplexity();

            int xPositions[] = new int[(int)(complexity / 2)];
            int yPositions[] = new int[(int)(complexity / 2)];

            Circle[] circle = new Circle[(int)(complexity / 2) * 2];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2) * 2];
            for(int i=0; i<(2*(int)(complexity / 2)); i+=2)
            {
                int xPos = (int)(Math.random()*800);
                int yPos = (int)(Math.random()*600);
                Color color = drawable.myColors[(int)(Math.random()*drawable.myColors.length)];
                int size = layer1.getSize();

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

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(donutShape);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                layout.getChildren().add(donutShape);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer1.getShape()=="Dots")
        {
            int complexity = layer1.getComplexity();

            int xPositions[] = new int[(int)(complexity / 2)];
            int yPositions[] = new int[(int)(complexity / 2)];

            Circle[] circle = new Circle[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                int xPos = (int) (Math.random() * 800);
                int yPos = (int) (Math.random() * 600);
                Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(circle[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                circle[i].setCenterX(xPos);
                xPositions[i] = xPos;
                circle[i].setCenterY(yPos);
                yPositions[i] = yPos;
                circle[i].setFill(color);
                circle[i].setRadius((int)(Math.random()*3)+1);
                layout.getChildren().add(circle[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer1.getShape()=="Square")
        {
            int complexity = layer1.getComplexity();

            int[] xPositions = new int[(int)(complexity / 2)];
            int[] yPositions = new int[(int)(complexity / 2)];

            Rectangle[] rectangle = new Rectangle[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                int xPos = (int) (Math.random() * 800);
                int yPos = (int) (Math.random() * 600);
                Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                rectangle[i] = new Rectangle();

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(rectangle[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                rectangle[i].setX(xPos);
                xPositions[i] = xPos;
                rectangle[i].setY(yPos);
                yPositions[i] = yPos;
                rectangle[i].setFill(color);
                int temp = (int) (Math.random() * 3);
                rectangle[i].setWidth(layer1.getSize() * temp);
                rectangle[i].setHeight(layer1.getSize() * temp);
                layout.getChildren().add(rectangle[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer1.getShape()=="Polygons")
        {
            int complexity = layer1.getComplexity();

            Polygon[] polygon = new Polygon[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                polygon[i] = generatePolygon(layer1.getSize()*5, layer1.getSize()*5,
                                            (int) (Math.random() * 800), (int) (Math.random() * 600));

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(polygon[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                layout.getChildren().add(polygon[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        else if(layer1.getShape()=="Lines")
        {
            int complexity = layer1.getComplexity();

            Line[] line = new Line[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                double xStart, xEnd;
                double yStart, yEnd;

                xStart = (Math.random() * 800);
                xEnd =  (Math.random() * 800);
                yStart = (Math.random() * 600);
                yEnd =  (Math.random() * 600);

                line[i] = new Line(xStart, yStart, xEnd, yEnd);
                line[i].setStroke(drawable.myColors[(int)(Math.random()*drawable.myColors.length)]);

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(line[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                layout.getChildren().add(line[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Animation layer1 set: none");
        }

        if(layer2.getShape()=="Rectangle")
        {
            int complexity = layer2.getComplexity();

            int[] xPositions = new int[(int)(complexity / 2)];
            int[] yPositions = new int[(int)(complexity / 2)];

            Rectangle[] rectangle = new Rectangle[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                int xPos = (int) (Math.random() * 800);
                int yPos = (int) (Math.random() * 600);
                Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                rectangle[i] = new Rectangle();

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(rectangle[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                rectangle[i].setX(xPos);
                xPositions[i] = xPos;
                rectangle[i].setY(yPos);
                yPositions[i] = yPos;
                rectangle[i].setFill(color);
                rectangle[i].setWidth((int) (Math.random() * layer2.getSize()));
                rectangle[i].setHeight((int) (Math.random() * layer2.getSize()));
                layout.getChildren().add(rectangle[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer2.getShape()=="Circle")
        {
            int complexity = layer2.getComplexity();

            int xPositions[] = new int[(int)(complexity / 2)];
            int yPositions[] = new int[(int)(complexity / 2)];

            Circle[] circle = new Circle[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                int xPos = (int) (Math.random() * 800);
                int yPos = (int) (Math.random() * 600);
                Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(circle[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                circle[i].setCenterX(xPos);
                xPositions[i] = xPos;
                circle[i].setCenterY(yPos);
                yPositions[i] = yPos;
                circle[i].setFill(color);
                circle[i].setRadius((int) (layer2.getSize() * 3));
                layout.getChildren().add(circle[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer2.getShape()=="Ring")
        {
            int complexity = layer2.getComplexity();

            int xPositions[] = new int[(int)(complexity / 2)];
            int yPositions[] = new int[(int)(complexity / 2)];

            Circle[] circle = new Circle[(int)(complexity / 2) * 2];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2) * 2];
            for(int i=0; i<(2*(int)(complexity / 2)); i+=2)
            {
                int xPos = (int)(Math.random()*800);
                int yPos = (int)(Math.random()*600);
                Color color = drawable.myColors[(int)(Math.random()*drawable.myColors.length)];
                int size = layer2.getSize();

                // Drawing the solid circle
                circle[i] = new Circle();
                circle[i].setCenterX(xPos);
                circle[i].setCenterY(yPos);
                circle[i].setFill(color);
                circle[i].setRadius((int)(size * 3));

                // Now drawing transparent inner circle (should match background color)
                circle[i+1] = new Circle();
                circle[i+1].setCenterX(xPos);
                circle[i+1].setCenterY(yPos);
                circle[i+1].setFill(Color.TRANSPARENT);
                circle[i+1].setRadius((int)(size * 2));

                Shape donutShape = Shape.subtract(circle[i], circle[i+1]);
                donutShape.setFill(color);

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(donutShape);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                layout.getChildren().add(donutShape);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer2.getShape()=="Dots")
        {
            int complexity = layer2.getComplexity();

            int xPositions[] = new int[(int)(complexity / 2)];
            int yPositions[] = new int[(int)(complexity / 2)];

            Circle[] circle = new Circle[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                int xPos = (int) (Math.random() * 800);
                int yPos = (int) (Math.random() * 600);
                Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                circle[i] = new Circle();

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(circle[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                circle[i].setCenterX(xPos);
                xPositions[i] = xPos;
                circle[i].setCenterY(yPos);
                yPositions[i] = yPos;
                circle[i].setFill(color);
                circle[i].setRadius((int)(Math.random()*3)+1);
                layout.getChildren().add(circle[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer2.getShape()=="Square")
        {
            int complexity = layer2.getComplexity();

            int[] xPositions = new int[(int)(complexity / 2)];
            int[] yPositions = new int[(int)(complexity / 2)];

            Rectangle[] rectangle = new Rectangle[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                int xPos = (int) (Math.random() * 800);
                int yPos = (int) (Math.random() * 600);
                Color color = drawable.myColors[(int) (Math.random() * drawable.myColors.length)];

                rectangle[i] = new Rectangle();

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(rectangle[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                rectangle[i].setX(xPos);
                xPositions[i] = xPos;
                rectangle[i].setY(yPos);
                yPositions[i] = yPos;
                rectangle[i].setFill(color);
                int temp = (int) (Math.random() * 3);
                rectangle[i].setWidth(layer2.getSize() * temp);
                rectangle[i].setHeight(layer2.getSize() * temp);
                layout.getChildren().add(rectangle[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(layer2.getShape()=="Polygons")
        {
            int complexity = layer2.getComplexity();

            Polygon[] polygon = new Polygon[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                polygon[i] = generatePolygon(layer2.getSize()*5, layer2.getSize()*5,
                        (int) (Math.random() * 800), (int) (Math.random() * 600));

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(polygon[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                layout.getChildren().add(polygon[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        else if(layer2.getShape()=="Lines")
        {
            int complexity = layer2.getComplexity();

            Line[] line = new Line[(int)(complexity / 2)];
            TranslateTransition[] translateTransition = new TranslateTransition[(int)(complexity / 2)];
            for (int i = 0; i < (int) (complexity / 2); i++) {
                double xStart, xEnd;
                double yStart, yEnd;

                xStart = (Math.random() * 800);
                xEnd =  (Math.random() * 800);
                yStart = (Math.random() * 600);
                yEnd =  (Math.random() * 600);

                line[i] = new Line(xStart, yStart, xEnd, yEnd);
                line[i].setStroke(drawable.myColors[(int)(Math.random()*drawable.myColors.length)]);

                translateTransition[i] = new TranslateTransition();
                translateTransition[i].setDuration(Duration.millis(5000));
                translateTransition[i].setNode(line[i]);
                translateTransition[i].setByX((int)(Math.random()*100)-50);
                translateTransition[i].setByY((int)(Math.random()*100)-50);
                translateTransition[i].setCycleCount((int)(Math.random()*50));
                translateTransition[i].setAutoReverse(true);
                translateTransition[i].play();

                layout.getChildren().add(line[i]);
            }

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Animation layer2 set: none");
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
