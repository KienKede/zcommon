package com.zitro.zcommon.tools;

import javax.persistence.EntityNotFoundException;

import com.zitro.zcommon.exceptions.BadRequestException;

public final class ServicePreconditions {

    private ServicePreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Ensures that the entity reference passed as a parameter to the calling method is not null.
     * 
     * @param entity
     *            an object reference
     * @return the non-null reference that was validated
     * @throws MyEntityNotFoundException
     *             if {@code entity} is null
     */
    public static <T> T checkEntityExists(final T entity) {
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }

    public static void checkEntityExists(final boolean entityExists) {
        if (!entityExists) {
            throw new EntityNotFoundException();
        }
    }

    public static void checkOKArgument(final boolean okArgument) {
        if (!okArgument) {
            throw new BadRequestException();
        }
    }

}
