package org.tinker.order.server.repository.tk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Table(name = "order_uncompleted_order")
public class UncompletedOrder implements Serializable {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 价格
     */
    private BigDecimal amount;

    /**
     * 支付状态
     */
    @Column(name = "pay_state")
    private String payState;

    /**
     * 状态
     */
    @Column(name = "order_state")
    private String orderState;

    /**
     * 支付次数
     */
    @Column(name = "payment_times")
    private Integer paymentTimes;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private LocalDateTime orderTime;

    /**
     * 记录创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    public UncompletedOrder withId(String id) {
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    public UncompletedOrder withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    public UncompletedOrder withOrderId(String orderId) {
        this.setOrderId(orderId);
        return this;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    public UncompletedOrder withProductName(String productName) {
        this.setProductName(productName);
        return this;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取价格
     *
     * @return amount - 价格
     */
    public BigDecimal getAmount() {
        return amount;
    }

    public UncompletedOrder withAmount(BigDecimal amount) {
        this.setAmount(amount);
        return this;
    }

    /**
     * 设置价格
     *
     * @param amount 价格
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取支付状态
     *
     * @return pay_state - 支付状态
     */
    public String getPayState() {
        return payState;
    }

    public UncompletedOrder withPayState(String payState) {
        this.setPayState(payState);
        return this;
    }

    /**
     * 设置支付状态
     *
     * @param payState 支付状态
     */
    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    /**
     * 获取状态
     *
     * @return order_state - 状态
     */
    public String getOrderState() {
        return orderState;
    }

    public UncompletedOrder withOrderState(String orderState) {
        this.setOrderState(orderState);
        return this;
    }

    /**
     * 设置状态
     *
     * @param orderState 状态
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    /**
     * 获取支付次数
     *
     * @return payment_times - 支付次数
     */
    public Integer getPaymentTimes() {
        return paymentTimes;
    }

    public UncompletedOrder withPaymentTimes(Integer paymentTimes) {
        this.setPaymentTimes(paymentTimes);
        return this;
    }

    /**
     * 设置支付次数
     *
     * @param paymentTimes 支付次数
     */
    public void setPaymentTimes(Integer paymentTimes) {
        this.paymentTimes = paymentTimes;
    }

    /**
     * 获取下单时间
     *
     * @return order_time - 下单时间
     */
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public UncompletedOrder withOrderTime(LocalDateTime orderTime) {
        this.setOrderTime(orderTime);
        return this;
    }

    /**
     * 设置下单时间
     *
     * @param orderTime 下单时间
     */
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取记录创建时间
     *
     * @return create_time - 记录创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public UncompletedOrder withCreateTime(LocalDateTime createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * 设置记录创建时间
     *
     * @param createTime 记录创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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
        UncompletedOrder other = (UncompletedOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getPayState() == null ? other.getPayState() == null : this.getPayState().equals(other.getPayState()))
            && (this.getOrderState() == null ? other.getOrderState() == null : this.getOrderState().equals(other.getOrderState()))
            && (this.getPaymentTimes() == null ? other.getPaymentTimes() == null : this.getPaymentTimes().equals(other.getPaymentTimes()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getPayState() == null) ? 0 : getPayState().hashCode());
        result = prime * result + ((getOrderState() == null) ? 0 : getOrderState().hashCode());
        result = prime * result + ((getPaymentTimes() == null) ? 0 : getPaymentTimes().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append(", productName=").append(productName);
        sb.append(", amount=").append(amount);
        sb.append(", payState=").append(payState);
        sb.append(", orderState=").append(orderState);
        sb.append(", paymentTimes=").append(paymentTimes);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}