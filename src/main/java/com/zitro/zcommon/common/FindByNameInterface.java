package com.zitro.zcommon.common;

public interface FindByNameInterface<T extends ElementWithNameInterface> {

	T findByName(final String name);
	
}
