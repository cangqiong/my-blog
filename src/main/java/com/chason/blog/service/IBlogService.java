package com.chason.blog.service;

import com.chason.blog.bean.QueryResult;
import com.chason.blog.bean.req.AddBlogReq;
import com.chason.blog.bean.req.PageReq;
import com.chason.blog.bean.req.UpdateBlogReq;
import com.chason.blog.entity.Blog;

/**
 * 博客服务接口类
 *
 * @author cang
 * @date 2017-10-08
 */
public interface IBlogService {

    Integer saveBlog(AddBlogReq addBlogReq);

    void updateBlog(UpdateBlogReq updateBlogReq);

    void deleteBlog(Integer blogId);

    Blog queryBlogById(Integer blogId);

    QueryResult<Blog> queryBlogList(String searchKey, PageReq pageReq);

    QueryResult<Blog> queryBlogList(PageReq pageReq);

}
