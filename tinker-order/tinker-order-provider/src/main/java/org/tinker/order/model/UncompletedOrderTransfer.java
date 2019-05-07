package org.tinker.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UncompletedOrderTransfer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 价格
     */
    private BigDecimal amount;

    /**
     * 支付状态
     */
    private PayState payState;

    /**
     * 状态
     */
    private OrderState orderState;

    /**
     * 支付次数
     */
    private Integer paymentTimes;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;
}
