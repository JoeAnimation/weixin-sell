package com.longyx.weixin.sell.repository;

import com.longyx.weixin.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 9:07
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory>  findByCategoryTypeIn(List<Integer> categoryTypeList);
}
