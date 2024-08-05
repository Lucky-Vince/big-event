package com.wenxu.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wenxu.mapper.ArticleMapper;
import com.wenxu.pojo.Article;
import com.wenxu.pojo.PageBean;
import com.wenxu.service.ArticleService;
import com.wenxu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author zhaowenxu
 * @version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        // 补充属性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);

        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state) {
        // 1. 创建PageBean对象
        PageBean<Article> pb = new PageBean<>();

        // 2. 开启分页查询 PageHelper
        PageHelper.startPage(pageNum, pageSize);

        // 3. 调用mapper
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> as = articleMapper.list(userId, categoryId, state);

        // 4. 使用PageInfo包装查询结果
        PageInfo<Article> pageInfo = new PageInfo<>(as);

        // 5. 把数据填充到PageBean对象中
        pb.setTotal(pageInfo.getTotal());
        pb.setItems(pageInfo.getList());
        return pb;
    }

    @Override
    public Article detail(Integer id) {
        return articleMapper.getById(id);
    }

    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.deleteById(id);
    }
}
