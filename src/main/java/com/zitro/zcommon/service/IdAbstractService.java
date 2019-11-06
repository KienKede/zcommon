package com.zitro.zcommon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zitro.zcommon.persistence.domain.EntityWithIdInterface;
import com.zitro.zcommon.tools.ServicePreconditions;
import com.zitro.zcommon.tools.mapping.domain.IdAbstractMapping;
import com.zitro.zcommon.web.dto.DtoWithId;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public abstract class IdAbstractService<C extends DtoWithId, B extends DtoWithId, N extends DtoWithId, S extends EntityWithIdInterface> implements IdServiceInterface<C, B, N> {
	
	@Override
    @Transactional(readOnly = true)
    public N findOne(final Long id) {
    	Optional<S> entity = getDao().findById(id);
    	
    	if(entity.isPresent()) {
    		return getMapping().entityToDto(entity.get());
    	}
    	
    	return null;
    }

	@Override
	@Transactional(readOnly = true)
    public List<N> findAll() {
    	return getMapping().entityToDtoList(Lists.newArrayList(getDao().findAll()));
    }

	@Override
	@Transactional(readOnly = true)
    public List<N> findAllSorted(final String sortBy, final String sortOrder) {
    	final Sort sortInfo = constructSort(sortBy, sortOrder);
        return getMapping().entityToDtoList(Lists.newArrayList(getDao().findAll(sortInfo)));
    }

	@Override
	@Transactional(readOnly = true)
    public List<N> findAllPaginated(final int page, final int size) {
    	final List<S> content = getDao().findAll(PageRequest.of(page, size, null)).getContent();
        if (content == null) {
            return Lists.newArrayList();
        }
        return getMapping().entityToDtoList(content);
    }

	@Override
	@Transactional(readOnly = true)
    public List<N> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder) {
    	final Sort sortInfo = constructSort(sortBy, sortOrder);
        final List<S> content = getDao().findAll(PageRequest.of(page, size, sortInfo)).getContent();
        if (content == null) {
            return Lists.newArrayList();
        }
        return getMapping().entityToDtoList(content);
    }

	@Override
    public N create(final C entity) {
    	Preconditions.checkNotNull(entity);
    	
        return getMapping().entityToDto(getDao().save(getMapping().creationDtoToEntity(entity)));
    }

	@Override
    public void update(final B entity) {
    	Preconditions.checkNotNull(entity);

        getDao().save(getMapping().basicDtotoToEntity(entity));
    }

	@Override
    public void delete(final Long id) {
    	final Optional<S> entity = getDao().findById(id);
        if(entity.isPresent()) {
        	ServicePreconditions.checkEntityExists(entity);
        	getDao().delete(entity.get());	
        }
    }

	@Override
    public void deleteAll() {
    	getDao().deleteAll();
    }

    @Override
    public long count() {
    	return getDao().count();
    }
    
    @Override
    public Page<N> findAllPaginatedAndSortedByPage(final int page, final int size, final String sortBy, final String sortOrder) {
    	final Sort sortInfo = constructSort(sortBy, sortOrder);
        return getMapping().entityToDtoPage(getDao().findAll(PageRequest.of(page, size, sortInfo)));
    }
    
    public Page<N> findAllPaginatedByPage(final int page, final int size) {
        return getMapping().entityToDtoPage(getDao().findAll(PageRequest.of(page, size)));
    }
    
    protected abstract PagingAndSortingRepository<S, Long> getDao(); 
    
    protected abstract IdAbstractMapping<C, B, N, S> getMapping();
    
    protected final Sort constructSort(final String sortBy, final String sortOrder) {
        Sort sortInfo = null;
        if (sortBy != null) {
            sortInfo = new Sort(Direction.fromString(sortOrder), sortBy);
        }
        return sortInfo;
    }

}
