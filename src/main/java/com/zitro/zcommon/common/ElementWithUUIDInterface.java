package com.zitro.zcommon.common;

import java.io.Serializable;
import java.util.UUID;

public interface ElementWithUUIDInterface extends Serializable {

	public UUID getUUID ();
	
	public void setUUID (UUID uuid);
}
