package com.chason.blog.service;

import com.chason.blog.entity.User;

/**
 * 用户服务接口类
 *
 * @author cang
 * @date 2017-10-08
 */
public interface IUserService {

    User findByUsername(String name);

    User findByUserId(int userId);

    void validate(String username, String password);
}
