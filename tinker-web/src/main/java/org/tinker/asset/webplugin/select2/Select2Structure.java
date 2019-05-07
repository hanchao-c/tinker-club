package org.tinker.asset.webplugin.select2;

import java.io.Serializable;

/**
 * 前端插件select2结果
 */
public interface Select2Structure extends Serializable {

	
	
	/**
	 * @return
	 */
	String getId();
	
	/**
	 * 
	 * @return
	 */
	String getText();
	
	
	default Boolean getDisabled() {
		return Boolean.FALSE;
	}
}
