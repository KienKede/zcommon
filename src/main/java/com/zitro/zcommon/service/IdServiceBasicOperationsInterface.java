package com.zitro.zcommon.service;

import java.util.List;

import com.zitro.zcommon.web.dto.DtoWithId;

public interface IdServiceBasicOperationsInterface<C extends DtoWithId, B extends DtoWithId, N extends DtoWithId> {

    // find - one

    N findOne(final Long id);

    /**
     * - contract: if nothing is found, an empty list will be returned to the calling client <br>
     */
    List<N> findAll();

    /**
     * - contract: if nothing is found, an empty list will be returned to the calling client <br>
     */
    List<N> findAllSorted(final String sortBy, final String sortOrder);

    /**
     * - contract: if nothing is found, an empty list will be returned to the calling client <br>
     */
    List<N> findAllPaginated(final int page, final int size);

    /**
     * - contract: if nothing is found, an empty list will be returned to the calling client <br>
     */
    List<N> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    // create

    N create(final C resource);

    // update

    void update(final B resource);

    // delete

    void delete(final Long id);

    void deleteAll();

    // count

    long count();

}
