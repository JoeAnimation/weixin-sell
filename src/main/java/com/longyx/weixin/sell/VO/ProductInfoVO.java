package com.longyx.weixin.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品详情
 * @author Mr.Longyx
 * @date 2020年01月20日 12:07
 */
@Data
public class ProductInfoVO implements Serializable {
    private static final long serialVersionUID = 8952564324694326801L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name" )
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon" )
    private String productIcon;
}
