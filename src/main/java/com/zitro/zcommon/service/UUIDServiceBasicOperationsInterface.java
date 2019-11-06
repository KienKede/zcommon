package com.zitro.zcommon.service;

import java.util.List;
import java.util.UUID;

import com.zitro.zcommon.web.dto.DtoWithUUID;

public interface UUIDServiceBasicOperationsInterface<C extends DtoWithUUID, B extends DtoWithUUID, N extends DtoWithUUID> {

    // find - one

    N findOne(final UUID uuid);

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

    void delete(final UUID uuid);

    void deleteAll();

    // count

    long count();

}
