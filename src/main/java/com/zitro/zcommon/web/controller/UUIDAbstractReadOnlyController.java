package com.zitro.zcommon.web.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zitro.zcommon.exceptions.ResourceNotFoundException;
import com.zitro.zcommon.service.UUIDServiceInterface;
import com.zitro.zcommon.tools.RestPreconditions;
import com.zitro.zcommon.web.dto.DtoWithUUID;

public abstract class UUIDAbstractReadOnlyController<C extends DtoWithUUID, B extends DtoWithUUID, N extends DtoWithUUID> {
	
	protected final N findOneInternal(final UUID uuid) {
        return RestPreconditions.checkNotNull(getService().findOne(uuid));
    }

    protected final List<N> findAllInternal(final HttpServletRequest request) {
        if (request.getParameterNames().hasMoreElements()) {
            throw new ResourceNotFoundException();
        }

        return getService().findAll();
    }

    protected final List<N> findPaginatedAndSortedInternal(final int page, final int size, final String sortBy, final String sortOrder) {
        final Page<N> resultPage = getService().findAllPaginatedAndSortedByPage(page, size, sortBy, sortOrder);
        if (page > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }

        return resultPage.getContent();
    }

    protected final List<N> findPaginatedInternal(final int page, final int size) {
        final Page<N> resultPage = getService().findAllPaginatedByPage(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }

        return resultPage.getContent();
    }

    protected final List<N> findAllSortedInternal(final String sortBy, final String sortOrder) {
        return getService().findAllSorted(sortBy, sortOrder);
    }

    protected final long countInternal() {
        // InvalidDataAccessApiUsageException dataEx - ResourceNotFoundException
        return getService().count();
    }

    /**
     * Counts all {@link Privilege} resources in the system
     * 
     * @return
     */
    @GetMapping(value = "/count")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long count() {
        return countInternal();
    }

    // template method

    protected abstract UUIDServiceInterface<C, B, N> getService();
	
}
