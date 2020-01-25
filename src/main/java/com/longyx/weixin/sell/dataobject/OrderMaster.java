package com.longyx.weixin.sell.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.longyx.weixin.sell.enums.OrderStatusEnum;
import com.longyx.weixin.sell.enums.PayStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 14:06
 */
@Data
@DynamicUpdate
@Entity
@TableName("order_master")
@AllArgsConstructor
@NoArgsConstructor
public class OrderMaster implements Serializable {
    private static final long serialVersionUID = 3978984361764194488L;
    /**订单id.*/
    @Id
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
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    /**支付状态.*/
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间
     * private LocalDateTime createTime
     * @author Mr.Longyx
     * @date 2020/1/20 23:18
     */
    private Date createTime;

    /**更新时间.*/
    private Date updateTime;
}
