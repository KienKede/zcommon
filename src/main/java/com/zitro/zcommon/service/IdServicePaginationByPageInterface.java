package com.zitro.zcommon.service;

import org.springframework.data.domain.Page;

import com.zitro.zcommon.web.dto.DtoWithId;

public interface IdServicePaginationByPageInterface<N extends DtoWithId> {

    Page<N> findAllPaginatedAndSortedByPage(final int page, final int size, final String sortBy, final String sortOrder);
    
    Page<N> findAllPaginatedByPage(final int page, final int size);

}
