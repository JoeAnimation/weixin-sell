package com.longyx.weixin.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longyx.weixin.sell.dataobject.OrderDetail;
import com.longyx.weixin.sell.enums.OrderStatusEnum;
import com.longyx.weixin.sell.enums.PayStatusEnum;
import com.longyx.weixin.sell.utils.EnumUtil;
import com.longyx.weixin.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 配置为null的字段都不返回给前端
 * @JsonInclude(JsonInclude.Include.NON_NULL)
 * @author Mr.Longyx
 * @date 2020年01月20日 15:05
 */
@Data
@ToString
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 113847368069334753L;
    /**订单id.*/
    private String orderId;

    /**买家名字.*/
    private String buyerName;

    /**买家手机号.*/
    private String buyerPhone;

    /**买家地址.*/
    private String buyerAddress;

    /**买家微信OpenId.*/
    private String buyerOpenid;

    /**订单总金额.*/
    private BigDecimal orderAmount;

    /**订单状态，默认新下单.0新下单*/
    private Integer orderStatus;

    /**支付状态.*/
    private Integer payStatus;

    /**创建时间.*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**更新时间.*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

   private List<OrderDetail> orderDetailList = new ArrayList<>();

   @JsonIgnore
   public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
   }

   @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
