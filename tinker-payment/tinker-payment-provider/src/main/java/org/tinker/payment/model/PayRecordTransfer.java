package org.tinker.payment.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.tinker.payment.asset.constant.NoticeState;
import org.tinker.payment.asset.constant.PaymentState;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayRecordTransfer implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
    private String id;

    /**
     * 支付金额
     */
    private BigDecimal amount;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 支付状态
     */
    private PaymentState paymentState;

    /**
     * 支付时间
     */
    private LocalDateTime createTime;

    /**
     * 通知状态
     */
    private NoticeState noticeState;
    
    
    /**
     * 订单类型
     */
    private String[] orderTypeNames; 
}
