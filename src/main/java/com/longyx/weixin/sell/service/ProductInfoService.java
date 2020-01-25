package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dataobject.ProductInfo;
import com.longyx.weixin.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 10:56
 */
public interface ProductInfoService {
    Optional<ProductInfo> findById(String productId);
    /**
     * 查询所有在架商品
     * @author Mr.Longyx
     * @date 2020/1/20 10:58
     * @return java.util.List<com.longyx.weixin.sell.dataobject.ProductInfo>
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     * @author Mr.Longyx
     * @date 2020/1/20 16:30
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 扣库存
     * @author Mr.Longyx
     * @date 2020/1/20 16:30
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架
     * @author Mr.Longyx
     * @date 2020/1/23 18:28
     * @param productId 
     * @return com.longyx.weixin.sell.dataobject.ProductInfo
     */
    ProductInfo onSale(String productId);
    /**
     * 上架
     * @author Mr.Longyx
     * @date 2020/1/23 18:47
     * @param productId
     * @return com.longyx.weixin.sell.dataobject.ProductInfo
     */
    ProductInfo offSale(String productId);
}
