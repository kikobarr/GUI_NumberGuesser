import javax.swing.*;

public class NumberGuesserIllegalStateException extends Exception{
    public NumberGuesserIllegalStateException (String errorMessage){
        super (errorMessage);
    }
}