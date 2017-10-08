package com.cang.blog.mapper;

import com.cang.blog.model.BlogUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BlogUserMapper extends Mapper<BlogUser> {

    public BlogUser selectByUserName(String userName);
}