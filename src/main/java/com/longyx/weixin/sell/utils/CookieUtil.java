package com.longyx.weixin.sell.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * cookie工具类
 * @author Mr.Longyx
 * @date 2020/1/24 18:02
 */
public class CookieUtil {

    /**
     * 设置cookie
     * @author Mr.Longyx
     * @date 2020/1/24 17:35
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     * @author Mr.Longyx
     * @date 2020/1/24 17:35
     * @param request
     * @param name
     * @return javax.servlet.http.Cookie
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        }else {
            return null;
        }
    }

    /**
     * 将cookie封装成Map
     * @author Mr.Longyx
     * @date 2020/1/24 17:35
     * @param request
     * @return java.util.Map<java.lang.String,javax.servlet.http.Cookie>
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}

