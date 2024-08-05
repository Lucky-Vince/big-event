package com.wenxu.service;

import com.wenxu.pojo.Article;
import com.wenxu.pojo.PageBean;

/**
 * @author zhaowenxu
 * @version 1.0
 */
public interface ArticleService {

    // 新增文章
    void add(Article article);

    // 条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state);

    // 根据id查询文章详情
    Article detail(Integer id);

    // 更新文章
    void update(Article article);

    // 根据id删除文章
    void delete(Integer id);
}
