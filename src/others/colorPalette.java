package others;

import javafx.scene.paint.Color;

public class colorPalette
{
    // 4 colors
    private String color1, color2, color3, color4;

    // constructor
    public colorPalette(String color1, String color2, String color3, String color4) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }
    // constructor overloading
    public colorPalette(Color color1, Color color2, Color color3, Color color4) {
        this.color1 = color1.toString();
        this.color2 = color2.toString();
        this.color3 = color3.toString();
        this.color4 = color4.toString();
    }

    // getter and setter methods

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public String getColor4() {
        return color4;
    }

    public void setColor4(String color4) {
        this.color4 = color4;
    }

    public boolean isValid()
    {
        if(this.color1==null || this.color2==null || this.color3==null || this.color4==null)
            return false;
        return true;
    }

    // for debug
    public void debugDisplay()
    {
        System.out.println("Color palette initialized: "+color1+","+color2+","+color3+","+color4);
    }
}
