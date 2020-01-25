package com.longyx.weixin.sell.service.impl;

import com.longyx.weixin.sell.dataobject.SellerInfo;
import com.longyx.weixin.sell.repository.SellerInfoRepository;
import com.longyx.weixin.sell.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Longyx
 * @date 2020年01月24日 10:48
 */
@Service
public class SellerInfoServiceImpl implements SellerInfoService {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
