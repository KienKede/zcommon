package com.zitro.zcommon.exceptions;

public final class ConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConflictException() {
        super();
    }

    public ConflictException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConflictException(final String message) {
        super(message);
    }

    public ConflictException(final Throwable cause) {
        super(cause);
    }

}
