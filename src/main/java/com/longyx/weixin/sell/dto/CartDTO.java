package com.longyx.weixin.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 16:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO implements Serializable {
    private static final long serialVersionUID = -3766168260946308709L;

    /**商品id*/
    private String productId;

    /**商品数量*/
    private Integer productQuantity;

}
