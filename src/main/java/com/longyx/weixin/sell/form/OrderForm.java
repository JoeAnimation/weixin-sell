package com.longyx.weixin.sell.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 21:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm implements Serializable {
    private static final long serialVersionUID = -1408518549899230099L;
    /**
     * 买家姓名
     * @author Mr.Longyx
     * @date 2020/1/20 21:35
     */
    @NotEmpty(message = "姓名必填")
    private String name;
    /**
     * 买家手机号
     * @author Mr.Longyx
     * @date 2020/1/20 21:35
     */
    @NotEmpty(message = "手机号必填" )
    private String phone;

    /**
     * 买家收货地址
     * @author Mr.Longyx
     * @date 2020/1/20 21:38
     */
    @NotEmpty(message = "地址必填" )
    private String address;
    /**
     * 买家微信id
     * @author Mr.Longyx
     * @date 2020/1/20 21:35
     */
    @NotEmpty(message = "openid必填")
    private String openid;


    /**
     * 购物车信息
     * @author Mr.Longyx
     * @date 2020/1/20 21:38
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
