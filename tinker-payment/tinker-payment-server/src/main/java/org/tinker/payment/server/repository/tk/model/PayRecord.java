package org.tinker.payment.server.repository.tk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Table(name = "payment_pay_record")
public class PayRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 支付金额
     */
    private BigDecimal amount;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 支付状态
     */
    @Column(name = "payment_state")
    private String paymentState;

    /**
     * 支付时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 通知状态
     */
    @Column(name = "notice_state")
    private String noticeState;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    public PayRecord withId(String id) {
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
     * 获取支付金额
     *
     * @return amount - 支付金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    public PayRecord withAmount(BigDecimal amount) {
        this.setAmount(amount);
        return this;
    }

    /**
     * 设置支付金额
     *
     * @param amount 支付金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    public PayRecord withOrderId(String orderId) {
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
     * 获取支付状态
     *
     * @return payment_state - 支付状态
     */
    public String getPaymentState() {
        return paymentState;
    }

    public PayRecord withPaymentState(String paymentState) {
        this.setPaymentState(paymentState);
        return this;
    }

    /**
     * 设置支付状态
     *
     * @param paymentState 支付状态
     */
    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState == null ? null : paymentState.trim();
    }

    /**
     * 获取支付时间
     *
     * @return create_time - 支付时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public PayRecord withCreateTime(LocalDateTime createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * 设置支付时间
     *
     * @param createTime 支付时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取通知状态
     *
     * @return notice_state - 通知状态
     */
    public String getNoticeState() {
        return noticeState;
    }

    public PayRecord withNoticeState(String noticeState) {
        this.setNoticeState(noticeState);
        return this;
    }

    /**
     * 设置通知状态
     *
     * @param noticeState 通知状态
     */
    public void setNoticeState(String noticeState) {
        this.noticeState = noticeState == null ? null : noticeState.trim();
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
        PayRecord other = (PayRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPaymentState() == null ? other.getPaymentState() == null : this.getPaymentState().equals(other.getPaymentState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getNoticeState() == null ? other.getNoticeState() == null : this.getNoticeState().equals(other.getNoticeState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPaymentState() == null) ? 0 : getPaymentState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getNoticeState() == null) ? 0 : getNoticeState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", orderId=").append(orderId);
        sb.append(", paymentState=").append(paymentState);
        sb.append(", createTime=").append(createTime);
        sb.append(", noticeState=").append(noticeState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}