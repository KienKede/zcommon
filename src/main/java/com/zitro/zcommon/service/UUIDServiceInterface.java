package com.zitro.zcommon.service;

import com.zitro.zcommon.web.dto.DtoWithUUID;

public interface UUIDServiceInterface<C extends DtoWithUUID, B extends DtoWithUUID, N extends DtoWithUUID> extends UUIDServiceBasicOperationsInterface<C, B, N>, UUIDServicePaginationByPageInterface<N>  {

}
