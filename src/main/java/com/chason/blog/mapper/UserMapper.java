package com.chason.blog.mapper;

import com.chason.blog.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    public User selectByUserName(String userName);
}