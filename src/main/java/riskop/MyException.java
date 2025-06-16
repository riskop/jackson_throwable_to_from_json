package riskop;

public class MyException extends Exception {

    private ErrorCodeWithMessage errorCodeWithMessage;

    public MyException() {
        super();
    }

    public MyException(ErrorCodeWithMessage errorCodeWithMessage) {
        super();
        this.errorCodeWithMessage = errorCodeWithMessage;
    }

    public MyException(ErrorCodeWithMessage errorCodeWithMessage, String message) {
        super(message);
        this.errorCodeWithMessage = errorCodeWithMessage;
    }

    public MyException(ErrorCodeWithMessage errorCodeWithMessage, String message, Throwable cause) {
        super(message, cause);
        this.errorCodeWithMessage = errorCodeWithMessage;
    }

    public ErrorCodeWithMessage getErrorCodeWithMessage() {
        return errorCodeWithMessage;
    }

}
