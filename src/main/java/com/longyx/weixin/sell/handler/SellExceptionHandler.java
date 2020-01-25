package com.longyx.weixin.sell.handler;

import com.longyx.weixin.sell.VO.ResultVO;
import com.longyx.weixin.sell.config.BaseUrlConfig;
import com.longyx.weixin.sell.exception.SellException;
import com.longyx.weixin.sell.exception.SellerAuthorizeException;
import com.longyx.weixin.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理类
 * @author Mr.Longyx
 * @date 2020/1/24 21:54
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private BaseUrlConfig baseUrlConfig;

    /**
     * 拦截登录异常
     * http://weixin-sell.natapp1.cc/sell/wechat/qrAuthorize?returnUrl=http://weixin-sell.natapp1.cc/sell/seller/login
     * @author Mr.Longyx
     * @date 2020/1/24 21:58
     * @return org.springframework.web.servlet.ModelAndView
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
        .concat(baseUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(baseUrlConfig.getSell())
        .concat("/sell/seller/login")
        );
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ResultVO handlerSellerException(SellException exception){
        return ResultVOUtil.failure(exception.getCode(),exception.getMessage());
    }
}
