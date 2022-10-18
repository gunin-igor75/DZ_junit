package pro.sky.dz_junit.exeption;

public class ZeroDivideException extends IllegalArgumentException{
    public ZeroDivideException() {
        super();
    }

    public ZeroDivideException(String s) {
        super(s);
    }

    public ZeroDivideException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZeroDivideException(Throwable cause) {
        super(cause);
    }
}
