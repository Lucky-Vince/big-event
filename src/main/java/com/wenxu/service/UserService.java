package com.wenxu.service;

import com.wenxu.pojo.User;

/**
 * @author zhaowenxu
 * @version 1.0
 */
public interface UserService {

    // 根据用户名查询用户信息
    User findByUserName(String username);

    // 注册
    void register(String username, String password);

    // 更新用户信息
    void update(User user);

    // 更新头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String newPwd);
}
