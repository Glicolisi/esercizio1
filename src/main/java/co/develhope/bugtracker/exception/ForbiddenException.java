package co.develhope.bugtracker.exception;

public class ForbiddenException extends  RuntimeException{

    private static final long serialVersionUID = -451155179435176035L;

    public ForbiddenException(String message) {
        super(message);
    }
}
