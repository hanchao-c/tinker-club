package org.tinker.auth.shiro.model;

import java.io.Serializable;

public class ShiroPermission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7778053394552257065L;
	/**
     * 菜单链接
     */
    private String permission;
    
    /**
     * 后台权限
     */
    private String authorities;
    
    
    /**
     * 获取菜单链接
     *
     * @return permission - 权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置菜单链接
     *
     * @param permission 权限
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }
    
    /**
     * 获取后台权限
     * @return authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * 设置后台权限
     * @param authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities == null ? null : authorities.trim();
    }
	
}
