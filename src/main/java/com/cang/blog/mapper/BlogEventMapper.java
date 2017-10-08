package com.cang.blog.mapper;

import com.cang.blog.model.BlogEvent;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BlogEventMapper extends Mapper<BlogEvent> {
}