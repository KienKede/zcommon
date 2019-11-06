package com.zitro.zcommon.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zitro.zcommon.tools.RestPreconditions;
import com.zitro.zcommon.web.dto.DtoWithUUID;

public abstract class UUIDAbstractController<C extends DtoWithUUID, B extends DtoWithUUID, N extends DtoWithUUID> extends UUIDAbstractReadOnlyController<C, B, N>{
	
	public N createInternal(final C resource) {
		RestPreconditions.checkNotNull(resource);
		RestPreconditions.checkRequestState(resource.getUUID() == null);
		
		return getService().create(resource);
	}
	
	public void updateInternal(final UUID id, final B resource) {
		RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestElementNotNull(resource.getUUID());
        RestPreconditions.checkRequestState(resource.getUUID().equals(id));
        RestPreconditions.checkNotNull(getService().findOne(resource.getUUID()));

		getService().update(resource);
	}
	
	public void deleteByIdInternal(final UUID uuid) {
		getService().delete(uuid);
	}
	
	public void deleteAllInternal() {
		getService().deleteAll();
	}
	
	@GetMapping(value = "/count")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long count() {
        return countInternal();
    }
    
}
