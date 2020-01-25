package com.longyx.weixin.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 12:03
 */
@Data
public class ProductDetailVO implements Serializable {
    private static final long serialVersionUID = -2485311682567727741L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type" )
    private Integer categoryType;

    @JsonProperty("foods" )
    private List<ProductInfoVO> productInfoVOList;
}
