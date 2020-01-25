package com.longyx.weixin.sell.enums;

import lombok.Getter;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 14:09
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新下单"),
    FINISHED(1, "订单已完成"),
    CANCEL(2, "已取消该订单")
    ;
    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
