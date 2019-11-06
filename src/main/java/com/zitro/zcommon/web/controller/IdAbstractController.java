package com.zitro.zcommon.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zitro.zcommon.tools.RestPreconditions;
import com.zitro.zcommon.web.dto.DtoWithId;

public abstract class IdAbstractController<C extends DtoWithId, B extends DtoWithId, N extends DtoWithId> extends IdAbstractReadOnlyController<C, B, N>{
	
	public N createInternal(final C resource) {
		RestPreconditions.checkNotNull(resource);
		RestPreconditions.checkRequestState(resource.getId() == null);
		
		return getService().create(resource);
	}
	
	public void updateInternal(final long id, final B resource) {
		RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestElementNotNull(resource.getId());
        RestPreconditions.checkRequestState(resource.getId() == id);
        RestPreconditions.checkNotNull(getService().findOne(resource.getId()));

		getService().update(resource);
	}
	
	public void deleteByIdInternal(final Long id) {
		getService().delete(id);
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
