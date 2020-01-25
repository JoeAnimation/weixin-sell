package com.longyx.weixin.sell.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.longyx.weixin.sell.enums.ProductStatusEnum;
import com.longyx.weixin.sell.utils.EnumUtil;
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
 * @date 2020年01月20日 10:27
 */
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@TableName("product_info")
public class ProductInfo implements Serializable {
    private static final long serialVersionUID = -4396512769146104276L;
    @Id
    private String productId;

    /**名称.*/
    private String productName;

    /**单价*/
    private BigDecimal productPrice;

    /**库存*/
    private Integer productStock;

    /**描述*/
    private String productDescription;

    /**小图.*/
    private String productIcon;

    /**状态.0正常1下架*/
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**类目编号.*/
    private Integer categoryType;

    /**
     * 创建时间
     * private LocalDateTime createTime
     * @author Mr.Longyx
     * @date 2020/1/20 23:19
     */
    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
