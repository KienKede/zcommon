package com.zitro.zcommon.tools;

import com.zitro.zcommon.exceptions.BadRequestException;
import com.zitro.zcommon.exceptions.ConflictException;
import com.zitro.zcommon.exceptions.ResourceNotFoundException;

public class RestPreconditions {
	
	private RestPreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     *
     * @return the non-null reference that was validated
     *
     * @throws MyResourceNotFoundException
     *             if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference) {
        return checkNotNull(reference, null);
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     * @param message
     *            the message of the exception if the check fails
     *
     * @return the non-null reference that was validated
     *
     * @throws MyResourceNotFoundException
     *             if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference, final String message) {
        if (reference == null) {
            throw new ResourceNotFoundException(message);
        }
        return reference;
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     * @return the non-null reference that was validated
     *
     * @throws MyBadRequestException
     *             if {@code reference} is null
     */
    public static <T> T checkRequestElementNotNull(final T reference) {
        return checkRequestElementNotNull(reference, null);
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     * @param message
     *            the message of the exception if the check fails
     *
     * @return the non-null reference that was validated
     *
     * @throws MyBadRequestException
     *             if {@code reference} is null
     */
    public static <T> T checkRequestElementNotNull(final T reference, final String message) {
        if (reference == null) {
            throw new BadRequestException(message);
        }
        return reference;
    }

    /**
     * Ensures the truth of an expression
     *
     * @param expression
     *            a boolean expression
     *
     * @throws MyConflictException
     *             if {@code expression} is false
     */
    public static void checkRequestState(final boolean expression) {
        checkRequestState(expression, null);
    }

    /**
     * Ensures the truth of an expression
     *
     * @param expression
     *            a boolean expression
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws MyConflictException
     *             if {@code expression} is false
     */
    public static void checkRequestState(final boolean expression, final String message) {
        if (!expression) {
            throw new ConflictException(message);
        }
    }
}
