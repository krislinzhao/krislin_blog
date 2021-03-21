package cn.krislin.mall.service;

import cn.krislin.mbg.model.PmsProductAttributeCategory;
import cn.krislin.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 商品属性分类Service
 */
public interface PmsProductAttributeCategoryService {
    int create(String name);

    int update(Long id, String name);

    int delete(Long id);

    PmsProductAttributeCategory getItem(Long id);

    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
