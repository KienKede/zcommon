package com.zitro.zcommon.tools.mapping.domain;

import com.zitro.zcommon.persistence.domain.EntityWithUUIDInterface;
import com.zitro.zcommon.web.dto.DtoWithUUID;

public interface UUIDMapping <C extends DtoWithUUID, B extends DtoWithUUID, N extends DtoWithUUID, S extends EntityWithUUIDInterface> {
	
	public S creationDtoToEntity(C creationDTO);
	
	public S basicDtotoToEntity(B basicDTO);
	
	public S normalDtoToEntity(N normalDTO);
	
	public N entityToDto(S entity);
}
