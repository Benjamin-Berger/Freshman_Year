package assignment06;

public class CodeAccessException extends Exception {

    /**
     * Generated by Eclipse, which uses the serialver.exe tool
     */
    private static final long serialVersionUID = -5149527989071151037L;

    /**
     * No-argument constructor needed for serialization
     */
    public CodeAccessException() {
        super();
    }

    /**
     * Preferred constructor that sets the inherited message field
     * of the exception object
     * @param arg0 message passed by the exception that was thrown
     */
    public CodeAccessException(String arg0) {
        super(arg0);
    }
}