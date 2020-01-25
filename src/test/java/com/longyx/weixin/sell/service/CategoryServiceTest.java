package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void findById() {
        Optional<ProductCategory> productCategory = categoryService.findById(1);
        Assert.assertEquals(new Integer(1),productCategory.get().getCategoryId());
    }

    @Test
    void findAll() {
        List<ProductCategory> productCategories = categoryService.findAll();
        Assert.assertNotEquals(0, productCategories.size());
    }

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0, productCategories.size());
    }

    @Test
    void save() {
        ProductCategory productCategory = new ProductCategory("烤鸡翅", 3);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}