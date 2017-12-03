package com.chason.blog.mapper;

import com.chason.blog.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BlogMapper extends Mapper<Blog> {

    Integer insertAndGetId(Blog blog);

    List<Blog> searchByTitle(@Param( "searchKey" ) String searchKey, @Param( "rowBounds" ) RowBounds rowBounds);

    List<Blog> selectBlogList(@Param( "offset" ) int offset, @Param( "limit" ) int limit);

    int searchKeyCount(String searchKey);

}