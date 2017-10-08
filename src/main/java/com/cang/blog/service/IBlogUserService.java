package com.cang.blog.service;

import com.cang.blog.exception.UserNotFoundException;
import com.cang.blog.model.BlogUser;

/**
 * 用户服务接口类
 *
 * @author cang
 * @date 2017-10-08
 */
public interface IBlogUserService {

    BlogUser findByUsername(String name);

    BlogUser findByUserId(int userId);

    String validate(String username, String password) throws UserNotFoundException;
}
