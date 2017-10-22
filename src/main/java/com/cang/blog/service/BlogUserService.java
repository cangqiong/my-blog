package com.cang.blog.service;

import com.cang.blog.constant.SystemConstantEnum;
import com.cang.blog.exception.UserNotFoundException;
import com.cang.blog.mapper.BlogUserMapper;
import com.cang.blog.model.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务类
 *
 * @author cang
 * @date 2017-10-08
 */
@Service
public class BlogUserService implements IBlogUserService {

    @Autowired
    private BlogUserMapper blogUserMapper;

    /**
     * 验证用户登录信息
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public String validate(String username, String password) throws UserNotFoundException {

        BlogUser user = findByUsername(username);

        if (user == null) {
            throw new UserNotFoundException(SystemConstantEnum.USER_NOT_FOUND.getCode(), username);
        }

        if (password == null || !user.getPassword().equals(password)) {
            return SystemConstantEnum.PASS_NOT_CORRECT.getMsg();
        } else {
            return null;
        }
    }

    @Override
    public BlogUser findByUsername(String name) {

        return blogUserMapper.selectByUserName(name);
    }

    @Override
    public BlogUser findByUserId(int userId) {
        return blogUserMapper.selectByPrimaryKey(userId);
    }

}
