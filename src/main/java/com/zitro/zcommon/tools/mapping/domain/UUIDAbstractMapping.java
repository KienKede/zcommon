package com.zitro.zcommon.tools.mapping.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.zitro.zcommon.persistence.domain.EntityWithUUIDInterface;
import com.zitro.zcommon.web.dto.DtoWithUUID;

public abstract class UUIDAbstractMapping<C extends DtoWithUUID, B extends DtoWithUUID, N extends DtoWithUUID, S extends EntityWithUUIDInterface> implements UUIDMapping<C, B, N, S>{

	public List<N> entityToDtoList(List<S> entityList) {
		List<N> dtoList = new ArrayList<N>();
		for(S entity : entityList) {
			dtoList.add(this.entityToDto(entity));
		}
		return dtoList;
	}
	
	public Page<N> entityToDtoPage(Page<S> entityPage) {
		List<N> dtoList = new ArrayList<N>();
		
		for(S entity : entityPage) {
			dtoList.add(this.entityToDto(entity));
		}
		
		Pageable pageable = PageRequest.of(entityPage.getNumber(), entityPage.getSize());
		Page<N> dtoPage = new PageImpl<N>(dtoList, pageable, dtoList.size());
		
		return dtoPage;
		
	}
	
}
