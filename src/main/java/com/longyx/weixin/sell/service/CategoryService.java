package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 9:58
 */
public interface CategoryService {
    Optional<ProductCategory> findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);

    ProductCategory save(ProductCategory productCategory);
}
