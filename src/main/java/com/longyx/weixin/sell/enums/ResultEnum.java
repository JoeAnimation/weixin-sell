package com.longyx.weixin.sell.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 15:22
 */
@Getter
@NoArgsConstructor
public enum  ResultEnum {
    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存错误"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新异常"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),
    WECHAT_MP_ERROR(20, "微信公众号出现错误"),
    WXPAY_ASYNC_PAY_NOTIFY_ERROR(21, "微信支付异步通知金额校验不通过"),
    ORDER_CANCEL_SUCCESS(22, "取消订单成功"),
    ORDER_FINISH_SUCCESS(23,"订单成功完结"),
	PRODUCT_STATUS_ERROR(24, "商品状态不正确"),
    LOGIN_FAIL(25, "登录失败"),
    LOGOUT_FAIL(26, "登出失败"),
    LOGOUT_SUCCESS(27, "登出成功"),
    TOKEN_NOT_FOUND_IN_COOKIE(28, "cookie中查不到cookie"),
    TOKEN_NOT_FOUND_IN_REDIS(29, "redis中查不到该cookie"),
    ;
    private Integer code;
    private String msg;
    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
