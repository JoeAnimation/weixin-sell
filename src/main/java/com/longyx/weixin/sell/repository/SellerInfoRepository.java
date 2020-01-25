package com.longyx.weixin.sell.repository;

import com.longyx.weixin.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mr.Longyx
 * @date 2020年01月24日 10:13
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
