package riskop;

public class ErrorCodeWithMessage {

    private int errorCode;
    private String message;

    public ErrorCodeWithMessage() {
    }

    public ErrorCodeWithMessage(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
