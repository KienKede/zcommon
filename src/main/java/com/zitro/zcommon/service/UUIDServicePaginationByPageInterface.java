package com.zitro.zcommon.service;

import org.springframework.data.domain.Page;

import com.zitro.zcommon.web.dto.DtoWithUUID;

public interface UUIDServicePaginationByPageInterface<N extends DtoWithUUID> {

    Page<N> findAllPaginatedAndSortedByPage(final int page, final int size, final String sortBy, final String sortOrder);
    
    Page<N> findAllPaginatedByPage(final int page, final int size);

}
