package com.chason.blog.mapper;

import com.chason.blog.entity.Comment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CommentMapper extends Mapper<Comment> {
}