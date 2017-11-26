package com.chason.blog.mapper;

import com.chason.blog.entity.Image;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ImageMapper extends Mapper<Image> {
}