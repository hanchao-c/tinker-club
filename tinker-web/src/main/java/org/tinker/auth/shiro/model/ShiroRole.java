package org.tinker.auth.shiro.model;

import java.io.Serializable;

import javax.persistence.Id;

public class ShiroRole implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    private String id;

	/**
     * @return id
     */
    public String getId() {
        return id;
    }
    
    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
}
