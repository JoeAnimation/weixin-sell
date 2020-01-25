package com.longyx.weixin.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @author Mr.Longyx
 * @date 2020年01月20日 11:52
 */
@Data
public class ResultVO<T> implements Serializable {
    /**返回的状态码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**返回的具体内容*/
    private T data;
}
