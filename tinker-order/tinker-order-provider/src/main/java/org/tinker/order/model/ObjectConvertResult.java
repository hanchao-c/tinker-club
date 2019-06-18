package org.tinker.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.tinker.asset.JacksonEnumTemplateDeserializer;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ObjectConvertResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 /**
     * 用户id
     */
	private String userId;

	 /**
     * 订单id
     */
	private Long orderId;

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
	@JsonDeserialize(using = JacksonEnumTemplateDeserializer.class)
	private PayState payState;

	/**
     * 状态
     */
	@JsonDeserialize(using = JacksonEnumTemplateDeserializer.class)
	private OrderState orderState;

	/**
     * 支付次数
     */
	private Long paymentTimes;

	 /**
     * 下单时间
     */
	private LocalDateTime orderTime;

	/**
     * 记录创建时间
     */
	private LocalDateTime createTime;
	
	
}
