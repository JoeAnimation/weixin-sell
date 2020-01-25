package com.longyx.weixin.sell.service.impl;

import com.longyx.weixin.sell.dataobject.ProductInfo;
import com.longyx.weixin.sell.dto.CartDTO;
import com.longyx.weixin.sell.enums.ProductStatusEnum;
import com.longyx.weixin.sell.enums.ResultEnum;
import com.longyx.weixin.sell.exception.SellException;
import com.longyx.weixin.sell.repository.ProductInfoRepository;
import com.longyx.weixin.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 11:00
 */
@Service
//@CacheConfig(cacheNames = {"product"})  提升作用域
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
 //   @Cacheable(cacheNames = {"product"},key = "weixin")
    //   @Cacheable(key = "weixin") 对应作用域提升的情况
    public Optional<ProductInfo> findById(String productId) {
        return repository.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
 //   @CachePut(cacheNames = {"product"},key = "weixin")
    //   @CachePut(key = "weixin")
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            if(productInfo.get() == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.get().getProductStock() + cartDTO.getProductQuantity();
            productInfo.get().setProductStock(result);

            repository.save(productInfo.get());
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
           Optional<ProductInfo> productInfo =  repository.findById(cartDTO.getProductId());
           if(productInfo.get() == null){
               throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
           }
           Integer result = productInfo.get().getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.get().setProductStock(result);

            repository.save(productInfo.get());
        }
    }
	
	@Override
    public ProductInfo onSale(String productId) {
        Optional<ProductInfo> productInfo = repository.findById(productId);
        if (productInfo.get() == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.get().getProductStatusEnum().equals(ProductStatusEnum.UP)) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.get().setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo.get());
    }

    @Override
    public ProductInfo offSale(String productId) {
        Optional<ProductInfo> productInfo = repository.findById(productId);
        if (productInfo.get() == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.get().getProductStatusEnum().equals(ProductStatusEnum.DOWN)) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.get().setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo.get());
    }
}
