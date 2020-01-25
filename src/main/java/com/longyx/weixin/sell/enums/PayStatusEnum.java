package com.longyx.weixin.sell.enums;

import lombok.Getter;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 14:08
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    CANCEL(3, "取消支付")
    ;
    private Integer code;
    private String msg;
    PayStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg=msg;
    }
}
