package com.longyx.weixin.sell.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 14:14
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@TableName("order_detail")
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 5623503904143138931L;
    /**详情Id.*/
    @Id
    private String detailId;

    /**订单Id.*/
    private String  orderId;

    /**商品Id.*/
    private String productId;

    /**商品名称.*/
    private String productName;

    /**商品价格.*/
    private BigDecimal productPrice;

    /**商品数量.*/
    private Integer productQuantity;

    /**商品小图.*/
    private String productIcon;

    /**
     * 创建时间
     * private LocalDateTime createTime
     * @author Mr.Longyx
     * @date 2020/1/20 23:17
     */
    private Date createTime;

    /**更新时间*/
    private Date updateTime;
}
