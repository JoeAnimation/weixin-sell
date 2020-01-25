package com.longyx.weixin.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Mr.Longyx
 * @date 2020年01月22日 15:16
 */
public class JsonUtil {

    /**
     * 将
     * @author Mr.Longyx
     * @date 2020/1/22 15:33
     * @param object 
     * @return java.lang.String
     */
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
