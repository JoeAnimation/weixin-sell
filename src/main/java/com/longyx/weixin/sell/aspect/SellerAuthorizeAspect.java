package com.longyx.weixin.sell.aspect;

import com.longyx.weixin.sell.constant.CookieConstant;
import com.longyx.weixin.sell.constant.RedisConstant;
import com.longyx.weixin.sell.enums.ResultEnum;
import com.longyx.weixin.sell.exception.SellerAuthorizeException;
import com.longyx.weixin.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 商家授权切面类
 * @author Mr.Longyx
 * @date 2020/1/24 21:13
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.longyx.weixin.sell.controller.Seller*.*(..))" +
    "&& !execution(public * com.longyx.weixin.sell.controller.SellerLoginController.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException(ResultEnum.TOKEN_NOT_FOUND_IN_COOKIE);
        }

        //redis中查询cookie
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException(ResultEnum.TOKEN_NOT_FOUND_IN_REDIS);
        }
    }
}
