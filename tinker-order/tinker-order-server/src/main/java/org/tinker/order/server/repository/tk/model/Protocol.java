package org.tinker.order.server.repository.tk.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "order_protocol")
public class Protocol implements Serializable {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 条款
     */
    private String item;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    public Protocol withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取条款
     *
     * @return item - 条款
     */
    public String getItem() {
        return item;
    }

    public Protocol withItem(String item) {
        this.setItem(item);
        return this;
    }

    /**
     * 设置条款
     *
     * @param item 条款
     */
    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
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
        Protocol other = (Protocol) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getItem() == null ? other.getItem() == null : this.getItem().equals(other.getItem()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItem() == null) ? 0 : getItem().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", item=").append(item);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}