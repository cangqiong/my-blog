package com.chason.blog.controller;

import com.chason.blog.entity.User;
import com.chason.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 用户测试文件
 *
 * @author cang
 * @date 2017-10-07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    private Date now = new Date();

    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping(value = "/add")
    public boolean addUser() {
        User user = new User();
        user.setUserName("test");
        user.setPassword("pass");
        user.setCreateTime(now);
        user.setModifyTime(now);
        int updateCount = userMapper.insertSelective(user);
        return updateCount == 1;
    }

    /**
     * 修改用户
     *
     * @return
     */
    @RequestMapping(value = "/update")
    public boolean updateUser() {

        User user = new User();
        user.setUserId(1);
        user.setUserName("update-name");
        user.setModifyTime(now);
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        return updateCount == 1;
    }

    /**
     * 删除用户
     *
     * @return
     */
    @RequestMapping(value = "/delete")
    public boolean deleteUser() {

        User user = new User();
        user.setUserId(1);
        int updateCount = userMapper.deleteByPrimaryKey(user);
        return updateCount == 1;
    }

    /**
     * 查询用户
     *
     * @return
     */
    @RequestMapping(value = "/queryAll")
    public List<User> queryAllUser() {

        return userMapper.selectAll();
    }

    /**
     * 根据用户ID查询用户
     *
     * @return
     */
    @RequestMapping(value = "/queryById")
    public User queryUser() {
        User user = new User();
        user.setUserId(1);
        return userMapper.selectByPrimaryKey(user);
    }

}
