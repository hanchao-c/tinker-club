package org.tinker.cms.repository.tk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Table(name = "cms_watch")
public class Watch implements Serializable {
    /**
     * 主键 uuid 
     */
    @Id
    private String id;

    /**
     * 主题
     */
    private String subject;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 类型 
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片链接
     */
    @Column(name = "main_picture_url")
    private String mainPictureUrl;

    /**
     * 子图片链接
     */
    @Column(name = "sub_picture_urls")
    private String subPictureUrls;

    /**
     * 标签
     */
    private String tags;

    /**
     * 状态
     */
    private String state;

    /**
     * 记录最后更新时间
     */
    @Column(name = "last_modifed_time")
    private LocalDateTime lastModifedTime;

    /**
     * 操作人账号
     */
    private String opertor;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键 uuid 
     *
     * @return id - 主键 uuid 
     */
    public String getId() {
        return id;
    }

    public Watch withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * 设置主键 uuid 
     *
     * @param id 主键 uuid 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取主题
     *
     * @return subject - 主题
     */
    public String getSubject() {
        return subject;
    }

    public Watch withSubject(String subject) {
        this.setSubject(subject);
        return this;
    }

    /**
     * 设置主题
     *
     * @param subject 主题
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    public Watch withPrice(BigDecimal price) {
        this.setPrice(price);
        return this;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    public Watch withBrand(String brand) {
        this.setBrand(brand);
        return this;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 获取类型 
     *
     * @return type - 类型 
     */
    public String getType() {
        return type;
    }

    public Watch withType(String type) {
        this.setType(type);
        return this;
    }

    /**
     * 设置类型 
     *
     * @param type 类型 
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    public Watch withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取图片链接
     *
     * @return main_picture_url - 图片链接
     */
    public String getMainPictureUrl() {
        return mainPictureUrl;
    }

    public Watch withMainPictureUrl(String mainPictureUrl) {
        this.setMainPictureUrl(mainPictureUrl);
        return this;
    }

    /**
     * 设置图片链接
     *
     * @param mainPictureUrl 图片链接
     */
    public void setMainPictureUrl(String mainPictureUrl) {
        this.mainPictureUrl = mainPictureUrl == null ? null : mainPictureUrl.trim();
    }

    /**
     * 获取子图片链接
     *
     * @return sub_picture_urls - 子图片链接
     */
    public String getSubPictureUrls() {
        return subPictureUrls;
    }

    public Watch withSubPictureUrls(String subPictureUrls) {
        this.setSubPictureUrls(subPictureUrls);
        return this;
    }

    /**
     * 设置子图片链接
     *
     * @param subPictureUrls 子图片链接
     */
    public void setSubPictureUrls(String subPictureUrls) {
        this.subPictureUrls = subPictureUrls == null ? null : subPictureUrls.trim();
    }

    /**
     * 获取标签
     *
     * @return tags - 标签
     */
    public String getTags() {
        return tags;
    }

    public Watch withTags(String tags) {
        this.setTags(tags);
        return this;
    }

    /**
     * 设置标签
     *
     * @param tags 标签
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public String getState() {
        return state;
    }

    public Watch withState(String state) {
        this.setState(state);
        return this;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取记录最后更新时间
     *
     * @return last_modifed_time - 记录最后更新时间
     */
    public LocalDateTime getLastModifedTime() {
        return lastModifedTime;
    }

    public Watch withLastModifedTime(LocalDateTime lastModifedTime) {
        this.setLastModifedTime(lastModifedTime);
        return this;
    }

    /**
     * 设置记录最后更新时间
     *
     * @param lastModifedTime 记录最后更新时间
     */
    public void setLastModifedTime(LocalDateTime lastModifedTime) {
        this.lastModifedTime = lastModifedTime;
    }

    /**
     * 获取操作人账号
     *
     * @return opertor - 操作人账号
     */
    public String getOpertor() {
        return opertor;
    }

    public Watch withOpertor(String opertor) {
        this.setOpertor(opertor);
        return this;
    }

    /**
     * 设置操作人账号
     *
     * @param opertor 操作人账号
     */
    public void setOpertor(String opertor) {
        this.opertor = opertor == null ? null : opertor.trim();
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
        Watch other = (Watch) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMainPictureUrl() == null ? other.getMainPictureUrl() == null : this.getMainPictureUrl().equals(other.getMainPictureUrl()))
            && (this.getSubPictureUrls() == null ? other.getSubPictureUrls() == null : this.getSubPictureUrls().equals(other.getSubPictureUrls()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getLastModifedTime() == null ? other.getLastModifedTime() == null : this.getLastModifedTime().equals(other.getLastModifedTime()))
            && (this.getOpertor() == null ? other.getOpertor() == null : this.getOpertor().equals(other.getOpertor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMainPictureUrl() == null) ? 0 : getMainPictureUrl().hashCode());
        result = prime * result + ((getSubPictureUrls() == null) ? 0 : getSubPictureUrls().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getLastModifedTime() == null) ? 0 : getLastModifedTime().hashCode());
        result = prime * result + ((getOpertor() == null) ? 0 : getOpertor().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", subject=").append(subject);
        sb.append(", price=").append(price);
        sb.append(", brand=").append(brand);
        sb.append(", type=").append(type);
        sb.append(", description=").append(description);
        sb.append(", mainPictureUrl=").append(mainPictureUrl);
        sb.append(", subPictureUrls=").append(subPictureUrls);
        sb.append(", tags=").append(tags);
        sb.append(", state=").append(state);
        sb.append(", lastModifedTime=").append(lastModifedTime);
        sb.append(", opertor=").append(opertor);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}