package com.example.demo.exception;

public class UtilException extends RuntimeException {
	private static final long serialVersionUID = 3338405359271762532L;

	public UtilException(Throwable cause) {
        super(cause);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }

}
