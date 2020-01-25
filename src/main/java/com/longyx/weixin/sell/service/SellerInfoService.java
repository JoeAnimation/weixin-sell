package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dataobject.SellerInfo;

/**
 * 卖家端管理
 * @author Mr.Longyx
 * @date 2020年01月24日 10:46
 */
public interface SellerInfoService {
    /**
     * 通过openid查询卖家端信息
     * @author Mr.Longyx
     * @date 2020/1/24 10:50
     * @param openid 
     * @return com.longyx.weixin.sell.dataobject.SellerInfo
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
