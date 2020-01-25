package com.longyx.weixin.sell.exception;

import com.longyx.weixin.sell.enums.ResultEnum;

/**
 * @author Mr.Longyx
 * @date 2020年01月24日 21:34
 */
public class SellerAuthorizeException extends RuntimeException {

    private Integer code;

    public SellerAuthorizeException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public SellerAuthorizeException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
