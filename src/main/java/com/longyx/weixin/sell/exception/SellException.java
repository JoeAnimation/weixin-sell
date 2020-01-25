package com.longyx.weixin.sell.exception;

import com.longyx.weixin.sell.enums.ResultEnum;
import lombok.Data;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 15:20
 */
@Data
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
