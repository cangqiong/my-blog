package com.cang.blog.service;

import com.cang.blog.constant.CodeConstantEnum;
import com.cang.blog.exception.UserNotFoundException;
import com.cang.blog.mapper.BlogUserMapper;
import com.cang.blog.model.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
    public String validate(String username, String password) {

        BlogUser user = findByUsername(username);

        if (user == null) {
            throw new UserNotFoundException(username);
        }

        if (password == null || user.getPassword().equals(password)) {
            return CodeConstantEnum.PASS_NOT_CORRECT.getMsg();
        }

        return null;
    }


    @Override
    public BlogUser findByUsername(String name) {

        BlogUser blogUser = new BlogUser();
        blogUser.setUserName(name);

        List<BlogUser> blogUserList = blogUserMapper.selectByExample(blogUser);
        if (!CollectionUtils.isEmpty(blogUserList)) {
            return blogUserList.get(0);
        }
        return null;
    }

    @Override
    public BlogUser findByUserId(int userId) {
        return blogUserMapper.selectByPrimaryKey(userId);
    }

}
