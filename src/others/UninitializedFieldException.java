package others;

public class UninitializedFieldException extends Exception
{
    private String errorMessage;
    public UninitializedFieldException(String message)
    {
        this.errorMessage = message;
    }
    public String toString()
    {
        return("Uninitialized Field Exception: "+errorMessage);
    }
}
