package com.longyx.weixin.sell.form;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Mr.Longyx
 * @date 2020年01月23日 18:48
 */
@Data
@ToString
public class ProductForm implements Serializable {
    private static final long serialVersionUID = -5185572634924913693L;
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}

