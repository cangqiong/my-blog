package com.cang.blog.controller;

import com.cang.blog.mapper.BlogUserMapper;
import com.cang.blog.model.BlogUser;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户测试文件
 *
 * @author cang
 * @date 2017-10-07
 */
@RestController
public class UserTestController {

    @Autowired
    private BlogUserMapper blogUserMapper;

    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping(value = "/user/add")
    public boolean addUser() {
        BlogUser user = new BlogUser();
        user.setUserName("test");
        user.setPassword("pass");
        int updateCount = blogUserMapper.insert(user);
        return updateCount == 1;
    }

    /**
     * 修改用户
     *
     * @return
     */
    @RequestMapping(value = "/user/update")
    public boolean updateUser() {

        BlogUser user = new BlogUser();
        user.setId(1);
        user.setUserName("update-name");
        int updateCount = blogUserMapper.updateByPrimaryKeySelective(user);
        return updateCount == 1;
    }

    /**
     * 删除用户
     *
     * @return
     */
    @RequestMapping(value = "/user/delete")
    public boolean deleteUser() {

        BlogUser user = new BlogUser();
        user.setId(1);
        int updateCount = blogUserMapper.deleteByPrimaryKey(user);
        return updateCount == 1;
    }

    /**
     * 查询用户
     *
     * @return
     */
    @RequestMapping(value = "/user/queryAll")
    public List<BlogUser> queryAllUser() {

        return blogUserMapper.selectAll();
    }

    /**
     * 根据用户ID查询用户
     *
     * @return
     */
    @RequestMapping(value = "/user/queryById")
    public BlogUser queryUser() {
        BlogUser user = new BlogUser();
        user.setId(1);
        return blogUserMapper.selectByPrimaryKey(user);
    }

}
