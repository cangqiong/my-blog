package com.chason.blog.service;

import com.chason.blog.entity.User;
import com.chason.blog.exception.UserNotFoundException;
import com.chason.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.chason.blog.constant.SystemConstantEnum.PASS_NOT_CORRECT;
import static com.chason.blog.constant.SystemConstantEnum.USER_NOT_FOUND;

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
    @Transactional( readOnly = true )
    public void validate(String username, String password) {

        User user = findByUsername(username);

        if (user == null) {
            throw new UserNotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMsg());
        }

        if (password == null || !user.getPassword().equals(password)) {
            throw new UserNotFoundException(PASS_NOT_CORRECT.getCode(), PASS_NOT_CORRECT.getMsg());
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
