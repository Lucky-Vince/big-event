package com.wenxu.mapper;

import com.wenxu.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhaowenxu
 * @version 1.0
 */
@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "VALUES(#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);

    List<Article> list(Integer userId, String categoryId, String state);

    @Select("SELECT * FROM article WHERE id=#{id}")
    Article getById(Integer id);

    @Update("UPDATE article SET id=#{id}, title=#{title}, content=#{content}, cover_img=#{coverImg}, state=#{state}, category_id=#{categoryId}, update_time=#{updateTime} WHERE id=#{id}")
    void update(Article article);

    @Delete("DELETE FROM article WHERE id=#{id}")
    void deleteById(Integer id);
}
