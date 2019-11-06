package com.zitro.zcommon.service;

import com.zitro.zcommon.web.dto.DtoWithId;

public interface IdServiceInterface<C extends DtoWithId, B extends DtoWithId, N extends DtoWithId> extends IdServiceBasicOperationsInterface<C, B, N>, IdServicePaginationByPageInterface<N>  {

}
