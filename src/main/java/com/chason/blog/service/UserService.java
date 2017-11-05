package com.chason.blog.service;

import com.chason.blog.constant.SystemConstantEnum;
import com.chason.blog.entity.User;
import com.chason.blog.exception.UserNotFoundException;
import com.chason.blog.mapper.UserMapper;
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
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

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

        User user = findByUsername(username);

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
    public User findByUsername(String name) {

        return userMapper.selectByUserName(name);
    }

    @Override
    public User findByUserId(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
