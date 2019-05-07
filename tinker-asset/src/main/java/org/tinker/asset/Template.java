package org.tinker.asset;

import java.io.Serializable;

/**
 * 
 */
public interface Template extends Serializable {

	String getCode();

	String getMessage();
	
	/**
	 * 
	 */
	public interface EnumTemplate extends Template {
	}
}
