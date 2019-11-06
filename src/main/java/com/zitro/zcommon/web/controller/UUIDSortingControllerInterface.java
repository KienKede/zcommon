package com.zitro.zcommon.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zitro.zcommon.web.dto.DtoWithUUID;

public interface UUIDSortingControllerInterface<N extends DtoWithUUID> {

    public List<N> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    public List<N> findAllPaginated(final int page, final int size);

    public List<N> findAllSorted(final String sortBy, final String sortOrder);

    public List<N> findAll(final HttpServletRequest request);

}
