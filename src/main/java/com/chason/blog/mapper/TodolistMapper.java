package com.chason.blog.mapper;

import com.chason.blog.entity.Todolist;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TodolistMapper extends Mapper<Todolist> {
}