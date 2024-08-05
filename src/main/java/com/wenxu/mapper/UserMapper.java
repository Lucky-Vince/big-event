package com.wenxu.mapper;

import com.wenxu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhaowenxu
 * @version 1.0
 */
@Mapper
public interface UserMapper {

    // 根据用户名查询用户
    @Select("SELECT * FROM user WHERE username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("INSERT INTO user(username, password, create_time, update_time)" +
            " VALUES(#{username}, #{password}, NOW(), NOW())")
    void add(String username, String password);

    // 更新用户信息
    @Update("UPDATE user SET nickname=#{nickname}, email=#{email}, update_time=#{updateTime} WHERE id=#{id}")
    void update(User user);

    // 更新头像
    @Update("UPDATE user SET user_pic=#{avatarUrl}, update_time=NOW() WHERE id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    // 更新密码
    @Update("UPDATE user SET password=#{newPassword},update_time=NOW() WHERE id=#{id}")
    void updatePwd(String newPassword, Integer id);
}
