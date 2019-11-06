package com.zitro.zcommon.tools.mapping.domain;

import com.zitro.zcommon.persistence.domain.EntityWithIdInterface;
import com.zitro.zcommon.web.dto.DtoWithId;

public interface IdMapping <C extends DtoWithId, B extends DtoWithId, N extends DtoWithId, S extends EntityWithIdInterface> {
	
	public S creationDtoToEntity(C creationDTO);
	
	public S basicDtotoToEntity(B basicDTO);
	
	public S normalDtoToEntity(N normalDTO);
	
	public N entityToDto(S entity);
}
