package org.tinker.auth.repository.tk.model;

import java.io.Serializable;
import javax.persistence.*;
import org.tinker.auth.shiro.model.ShiroPermission;

@Table(name = "auth_permission")
public class Permission extends ShiroPermission implements Serializable {
    /**
     * 主键 (可选UUID)
     */
    @Id
    private String id;

    /**
     * 菜单名称
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 是否是目录菜单
     */
    private Boolean catalog;

    /**
     * 序号
     */
    private Integer sequence;

    /**
     * 父菜单id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 备注
     */
    private String note;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键 (可选UUID)
     *
     * @return id - 主键 (可选UUID)
     */
    public String getId() {
        return id;
    }

    public Permission withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * 设置主键 (可选UUID)
     *
     * @param id 主键 (可选UUID)
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取菜单名称
     *
     * @return permission_name - 菜单名称
     */
    public String getPermissionName() {
        return permissionName;
    }

    public Permission withPermissionName(String permissionName) {
        this.setPermissionName(permissionName);
        return this;
    }

    /**
     * 设置菜单名称
     *
     * @param permissionName 菜单名称
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 获取是否是目录菜单
     *
     * @return catalog - 是否是目录菜单
     */
    public Boolean getCatalog() {
        return catalog;
    }

    public Permission withCatalog(Boolean catalog) {
        this.setCatalog(catalog);
        return this;
    }

    /**
     * 设置是否是目录菜单
     *
     * @param catalog 是否是目录菜单
     */
    public void setCatalog(Boolean catalog) {
        this.catalog = catalog;
    }

    /**
     * 获取序号
     *
     * @return sequence - 序号
     */
    public Integer getSequence() {
        return sequence;
    }

    public Permission withSequence(Integer sequence) {
        this.setSequence(sequence);
        return this;
    }

    /**
     * 设置序号
     *
     * @param sequence 序号
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 获取父菜单id
     *
     * @return parent_id - 父菜单id
     */
    public String getParentId() {
        return parentId;
    }

    public Permission withParentId(String parentId) {
        this.setParentId(parentId);
        return this;
    }

    /**
     * 设置父菜单id
     *
     * @param parentId 父菜单id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    public Permission withIcon(String icon) {
        this.setIcon(icon);
        return this;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    public Permission withNote(String note) {
        this.setNote(note);
        return this;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Permission other = (Permission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPermissionName() == null ? other.getPermissionName() == null : this.getPermissionName().equals(other.getPermissionName()))
            && (this.getCatalog() == null ? other.getCatalog() == null : this.getCatalog().equals(other.getCatalog()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getAuthorities() == null ? other.getAuthorities() == null : this.getAuthorities().equals(other.getAuthorities()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPermissionName() == null) ? 0 : getPermissionName().hashCode());
        result = prime * result + ((getCatalog() == null) ? 0 : getCatalog().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getAuthorities() == null) ? 0 : getAuthorities().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", catalog=").append(catalog);
        sb.append(", sequence=").append(sequence);
        sb.append(", parentId=").append(parentId);
        sb.append(", icon=").append(icon);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}