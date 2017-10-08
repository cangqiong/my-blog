package com.cang.blog.mapper;

import com.cang.blog.model.BlogTodolist;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BlogTodolistMapper extends Mapper<BlogTodolist> {
}