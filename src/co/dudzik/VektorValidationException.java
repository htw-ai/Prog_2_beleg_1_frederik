package co.dudzik;

public class VektorValidationException extends Exception {
    public VektorValidationException() {

    }

    public VektorValidationException(String message) {
        super (message);
    }

    public VektorValidationException(Throwable cause) {
        super (cause);
    }

    public VektorValidationException(String message, Throwable cause) {
        super (message, cause);
    }
}
