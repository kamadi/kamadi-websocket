package kz.kamadi.websocket.model;

public class Status {

    public final static int SUCCESS = 100;
    public final static int NOT_CONNECTED = 101;
    public final static int DEVICE_ERROR = 102;
    public final static int INTERNAL_ERROR = 103;

    private int code;
    private String message;

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
