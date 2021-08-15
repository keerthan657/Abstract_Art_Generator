package functionalities;

import javafx.scene.paint.Color;
import javafx.scene.Group;

import layer_shapes.*;
import others.colorPalette;
import others.layer;

public class drawable
{
    public static Color[] myColors;

    public void setColorPalette(colorPalette myColorPalette)
    {
        if(myColorPalette == null)
        {
            // default palette
            myColors = new Color[]{Color.BLACK, Color.RED, Color.CADETBLUE, Color.CYAN, Color.DARKORANGE};
        }
        else
        {
            //Red, Blue, Green, "Black", "Cyan", "Orange", "Pink", "Yellow", "Purple"
            myColors = new Color[4];

            if (myColorPalette.getColor1().equals("Red")) {
                myColors[0] = Color.RED;}
            else if (myColorPalette.getColor1().equals("Blue")) {
                myColors[0] = Color.BLUE;}
            else if (myColorPalette.getColor1().equals("Green")) {
                myColors[0] = Color.GREEN; }
            else if (myColorPalette.getColor1().equals("Black")) {
                myColors[0] = Color.BLACK; }
            else if (myColorPalette.getColor1().equals("Cyan")) {
                myColors[0] = Color.CYAN; }
            else if (myColorPalette.getColor1().equals("Orange")) {
                myColors[0] = Color.ORANGE; }
            else if (myColorPalette.getColor1().equals("Pink")) {
                myColors[0] = Color.PINK; }
            else if (myColorPalette.getColor1().equals("Yellow")) {
                myColors[0] = Color.YELLOW; }
            else if (myColorPalette.getColor1().equals("Purple")) {
                myColors[0] = Color.PURPLE; }
            else { myColors[0] = Color.DARKSEAGREEN; }

            if (myColorPalette.getColor2().equals("Red")) {
                myColors[1] = Color.RED;}
            else if (myColorPalette.getColor2().equals("Blue")) {
                myColors[1] = Color.BLUE;}
            else if (myColorPalette.getColor2().equals("Green")) {
                myColors[1] = Color.GREEN; }
            else if (myColorPalette.getColor2().equals("Black")) {
                myColors[1] = Color.BLACK; }
            else if (myColorPalette.getColor2().equals("Cyan")) {
                myColors[1] = Color.CYAN; }
            else if (myColorPalette.getColor2().equals("Orange")) {
                myColors[1] = Color.ORANGE; }
            else if (myColorPalette.getColor2().equals("Pink")) {
                myColors[1] = Color.PINK; }
            else if (myColorPalette.getColor2().equals("Yellow")) {
                myColors[1] = Color.YELLOW; }
            else if (myColorPalette.getColor2().equals("Purple")) {
                myColors[1] = Color.PURPLE; }
            else { myColors[1] = Color.DARKSEAGREEN; }

            if (myColorPalette.getColor3().equals("Red")) {
                myColors[2] = Color.RED;}
            else if (myColorPalette.getColor3().equals("Blue")) {
                myColors[2] = Color.BLUE;}
            else if (myColorPalette.getColor3().equals("Green")) {
                myColors[2] = Color.GREEN; }
            else if (myColorPalette.getColor3().equals("Black")) {
                myColors[2] = Color.BLACK; }
            else if (myColorPalette.getColor3().equals("Cyan")) {
                myColors[2] = Color.CYAN; }
            else if (myColorPalette.getColor3().equals("Orange")) {
                myColors[2] = Color.ORANGE; }
            else if (myColorPalette.getColor3().equals("Pink")) {
                myColors[2] = Color.PINK; }
            else if (myColorPalette.getColor3().equals("Yellow")) {
                myColors[2] = Color.YELLOW; }
            else if (myColorPalette.getColor3().equals("Purple")) {
                myColors[2] = Color.PURPLE; }
            else { myColors[2] = Color.DARKSEAGREEN; }

            if (myColorPalette.getColor4().equals("Red")) {
                myColors[3] = Color.RED;}
            else if (myColorPalette.getColor4().equals("Blue")) {
                myColors[3] = Color.BLUE;}
            else if (myColorPalette.getColor4().equals("Green")) {
                myColors[3] = Color.GREEN; }
            else if (myColorPalette.getColor4().equals("Black")) {
                myColors[3] = Color.BLACK; }
            else if (myColorPalette.getColor4().equals("Cyan")) {
                myColors[3] = Color.CYAN; }
            else if (myColorPalette.getColor4().equals("Orange")) {
                myColors[3] = Color.ORANGE; }
            else if (myColorPalette.getColor4().equals("Pink")) {
                myColors[3] = Color.PINK; }
            else if (myColorPalette.getColor4().equals("Yellow")) {
                myColors[3] = Color.YELLOW; }
            else if (myColorPalette.getColor4().equals("Purple")) {
                myColors[3] = Color.PURPLE; }
            else { myColors[3] = Color.DARKSEAGREEN; }
        }
    }

    public Group drawShape(layer layer1, layer layer2)
    {
        Group layout = new Group();

        String shape1 = layer1.getShape();
        String shape2 = layer2.getShape();

        // Layer 1 Stuff
        if(shape1.equals("Circle"))
        {
            DrawableCircle_Solid drawableCircle_Solid = new DrawableCircle_Solid(layer1.getComplexity(), layer1.getSize(), layer1.getStyle());
            drawableCircle_Solid.draw(layout);
        }
        else if(shape1.equals("Ring"))
        {
            DrawableCircle_Ring drawableCircle_Ring = new DrawableCircle_Ring(layer1.getComplexity(), layer1.getSize(), layer1.getStyle());
            drawableCircle_Ring.draw(layout);
        }
        else if(shape1.equals("Dots"))
        {
            // Dots are nothing but solid circles with very low radius
            DrawableCircle_Solid drawableCircle_Solid = new DrawableCircle_Solid(layer1.getComplexity(), ((int)(Math.random()*3)+1), layer1.getStyle());
            drawableCircle_Solid.draw(layout);
        }
        else if(shape1.equals("Square"))
        {
            DrawableBox_Square drawableBox_Square = new DrawableBox_Square(layer1.getComplexity(), layer1.getSize(), layer1.getStyle());
            drawableBox_Square.draw(layout);
        }
        else if(shape1.equals("Rectangle"))
        {
            DrawableBox_Rectangle drawableBox_Rectangle = new DrawableBox_Rectangle(layer1.getComplexity(), layer1.getSize(), layer1.getStyle());
            drawableBox_Rectangle.draw(layout);
        }
        else if(shape1.equals("Polygons"))
        {
            DrawableBox_Polygon drawableBox_Polygon = new DrawableBox_Polygon(layer1.getComplexity(), layer1.getSize(), layer1.getStyle());
            drawableBox_Polygon.draw(layout);
        }
        else if(shape1.equals("Lines"))
        {
            DrawableLine drawableLine = new DrawableLine(layer1.getComplexity(), layer1.getSize(), layer1.getStyle());
            drawableLine.draw(layout);
        }
        else
        {
            System.out.println("Layer1 shape: None");
            // nothing is drawn on screen
        }

        // Layer 2 Stuff
        if(shape2.equals("Circle"))
        {
            DrawableCircle_Solid drawableCircle_Solid = new DrawableCircle_Solid(layer2.getComplexity(), layer2.getSize(), layer2.getStyle());
            drawableCircle_Solid.draw(layout);
        }
        else if(shape2.equals("Ring"))
        {
            DrawableCircle_Ring drawableCircle_Ring = new DrawableCircle_Ring(layer2.getComplexity(), layer2.getSize(), layer2.getStyle());
            drawableCircle_Ring.draw(layout);
        }
        else if(shape2.equals("Dots"))
        {
            // Dots are nothing but solid circles with very low radius
            DrawableCircle_Solid drawableCircle_Solid = new DrawableCircle_Solid(layer2.getComplexity(), ((int)(Math.random()*3)+1), layer2.getStyle());
            drawableCircle_Solid.draw(layout);
        }
        else if(shape2.equals("Square"))
        {
            DrawableBox_Square drawableBox_Square = new DrawableBox_Square(layer2.getComplexity(), layer2.getSize(), layer2.getStyle());
            drawableBox_Square.draw(layout);
        }
        else if(shape2.equals("Rectangle"))
        {
            DrawableBox_Rectangle drawableBox_Rectangle = new DrawableBox_Rectangle(layer2.getComplexity(), layer2.getSize(), layer2.getStyle());
            drawableBox_Rectangle.draw(layout);
        }
        else if(shape2.equals("Polygons"))
        {
            DrawableBox_Polygon drawableBox_Polygon = new DrawableBox_Polygon(layer2.getComplexity(), layer2.getSize(), layer2.getStyle());
            drawableBox_Polygon.draw(layout);
        }
        else if(shape2.equals("Lines"))
        {
            DrawableLine drawableLine = new DrawableLine(layer2.getComplexity(), layer2.getSize(), layer2.getStyle());
            drawableLine.draw(layout);
        }
        else
        {
            System.out.println("Layer1 shape: None");
            // nothing is drawn on screen
        }

        return(layout);
    }
}
