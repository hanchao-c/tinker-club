package org.tinker.payment.server.repository.tk.model;

import java.io.Serializable;
import javax.persistence.*;
import org.tinker.payment.asset.constant.PaymentState;
import org.tinker.payment.asset.constant.PaymentType;

@Table(name = "payment_type")
public class PayType implements Serializable {
    @Id
    private String id;

    @Column(name = "payment_state")
    private PaymentState paymentState;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    public PayType withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return payment_state
     */
    public PaymentState getPaymentState() {
        return paymentState;
    }

    public PayType withPaymentState(PaymentState paymentState) {
        this.setPaymentState(paymentState);
        return this;
    }

    /**
     * @param paymentState
     */
    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    /**
     * @return payment_type
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public PayType withPaymentType(PaymentType paymentType) {
        this.setPaymentType(paymentType);
        return this;
    }

    /**
     * @param paymentType
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
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
        PayType other = (PayType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPaymentState() == null ? other.getPaymentState() == null : this.getPaymentState().equals(other.getPaymentState()))
            && (this.getPaymentType() == null ? other.getPaymentType() == null : this.getPaymentType().equals(other.getPaymentType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPaymentState() == null) ? 0 : getPaymentState().hashCode());
        result = prime * result + ((getPaymentType() == null) ? 0 : getPaymentType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", paymentState=").append(paymentState);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}