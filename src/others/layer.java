package others;

public class layer
{
    // 4 member variables
    private String style, shape;
    private int complexity, size;

    // constructor
    public layer(String style, String shape, double complexity, double size)
    {
        this.style = style;
        this.shape = shape;
        this.complexity = (int)complexity;
        this.size = (int)size;
    }

    // getter and setter methods

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isValid()
    {
        // if some fields are uninitialized
        if(this.style==null || this.shape==null)
            return false;
        return true;
    }

    // for debug
    public void debugDisplay()
    {
        System.out.println("Layer initialized: "+this.style+","+this.shape+","+this.complexity+","+this.size);
    }
}
