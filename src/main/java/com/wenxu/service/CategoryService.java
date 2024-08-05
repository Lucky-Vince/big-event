package com.wenxu.service;

import com.wenxu.pojo.Category;

import java.util.List;

/**
 * @author zhaowenxu
 * @version 1.0
 */
public interface CategoryService {

    // 新增分类
    void add(Category category);

    // 查询当前分类列表
    List<Category> list();

    // 根据id获取分类详情
    Category detail(Integer id);

    // 更新文章分类信息
    void update(Category category);

    // 根据id删除文章分类
    void delete(Integer id);

}
