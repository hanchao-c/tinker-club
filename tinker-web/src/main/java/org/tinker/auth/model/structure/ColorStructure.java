package org.tinker.auth.model.structure;

import org.apache.commons.lang3.StringUtils;
import org.tinker.asset.webplugin.select2.Select2Structure;

public class ColorStructure implements Select2Structure {

	private static final long serialVersionUID = 1L;
	private String color;

	public ColorStructure(String color) {
		this.color = color;
	}

	@Override
	public String getId() {
		return "ID - " + color;
	}

	@Override
	public String getText() {
		return color;
	}
	
	@Override
	public Boolean getDisabled() {
		if(StringUtils.startsWithAny(this.color, "o", "b", "g")) {
			this.color = color.concat(" --> disabled");
			return Boolean.TRUE;
		}
		return Select2Structure.super.getDisabled();
	}

	@Override
	public String toString() {
		return "ColorStructure [color=" + color + "]";
	}
	

}
