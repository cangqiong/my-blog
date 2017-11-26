package com.chason.blog.mapper;

import com.chason.blog.entity.Event;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface EventMapper extends Mapper<Event> {
}