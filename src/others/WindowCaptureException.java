package others;

public class WindowCaptureException extends Exception
{
    private String msg;
    public WindowCaptureException(String msg)
    {
        this.msg = msg;
    }
    public String toString()
    {
        return("Window capture exception: "+msg);
    }
}
