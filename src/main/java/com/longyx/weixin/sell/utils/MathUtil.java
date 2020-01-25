package com.longyx.weixin.sell.utils;

/**
 * @author Mr.Longyx
 * @date 2020年01月23日 0:03
 */
public class MathUtil {
    private static final Double NUM_RANGE = 0.01;
    /**
     * 两个浮点数的相等判断
     * @author Mr.Longyx
     * @date 2020/1/23 0:04
     * @param o1
     * @param o2 
     * @return java.lang.Boolean
     */
    public static Boolean equals(Double o1, Double o2){
        Double result = Math.abs(o1-o2);
        if (result < NUM_RANGE) {
            return true;
        }
        return false;
    }
}
