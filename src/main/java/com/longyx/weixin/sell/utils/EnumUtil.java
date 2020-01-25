package com.longyx.weixin.sell.utils;

import com.longyx.weixin.sell.enums.CodeEnum;
import com.longyx.weixin.sell.enums.OrderStatusEnum;
import com.longyx.weixin.sell.enums.ProductStatusEnum;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 10:31
 */
public class EnumUtil<T> {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}

