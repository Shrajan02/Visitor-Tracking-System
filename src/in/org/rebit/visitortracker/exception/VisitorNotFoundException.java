package in.org.rebit.visitortracker.exception;

// checked exception -> either declare or handle the exception
public class VisitorNotFoundException extends Exception {
    public VisitorNotFoundException(String message) {
        super(message);
    }
}
