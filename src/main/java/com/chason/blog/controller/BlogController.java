package com.chason.blog.controller;

import com.chason.blog.annotation.Authorization;
import com.chason.blog.bean.QueryResult;
import com.chason.blog.bean.ResultBean;
import com.chason.blog.bean.req.AddBlogReq;
import com.chason.blog.bean.req.DeleteBlogReq;
import com.chason.blog.bean.req.PageReq;
import com.chason.blog.bean.req.UpdateBlogReq;
import com.chason.blog.entity.Blog;
import com.chason.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 博客控制器
 *
 * @author cang
 * @date 2017-10-07
 */
@RestController
@RequestMapping( "/blog" )
public class BlogController {


    @Autowired
    private IBlogService blogService;

    @RequestMapping( value = "/add", method = RequestMethod.POST )
    @Authorization
    public ResultBean<Integer> addBlog(@RequestBody @Valid AddBlogReq addTodoListReq) {

        ResultBean<Integer> result = new ResultBean<>();

        Integer blogId = blogService.saveBlog(addTodoListReq);
        result.setData(blogId);

        return result;
    }

    @RequestMapping( value = "/update", method = RequestMethod.POST )
    @Authorization
    public ResultBean<Boolean> updateBlog(@RequestBody @Valid UpdateBlogReq updateBlogReq) {

        ResultBean<Boolean> resultBean = new ResultBean<>();
        blogService.updateBlog(updateBlogReq);
        return resultBean;
    }

    @RequestMapping( value = "/delete", method = RequestMethod.POST )
    @Authorization
    public ResultBean<Boolean> deleteBlog(@RequestBody @Valid DeleteBlogReq deleteBlogReq) {

        ResultBean<Boolean> basicRes = new ResultBean<>();

        blogService.deleteBlog(deleteBlogReq.getBlogId());

        return basicRes;
    }

    @RequestMapping( value = "/queryBlogList", method = RequestMethod.GET )
    public ResultBean<QueryResult<Blog>> queryBlogList(@NotNull( message = "分页信息不能为空" ) PageReq pageReq) throws Exception {

        ResultBean<QueryResult<Blog>> basicRes = new ResultBean<>();

        QueryResult<Blog> queryResult = blogService.queryBlogList(pageReq);

        basicRes.setData(queryResult);

        return basicRes;
    }

    @RequestMapping( value = "/query/{blogId}", method = RequestMethod.GET )
    public ResultBean<Blog> queryTodoList(@NotNull @PathVariable( "blogId" ) Integer blogId) throws Exception {

        ResultBean<Blog> basicRes = new ResultBean<>();

        Blog queryResult = blogService.queryBlogById(blogId);

        basicRes.setData(queryResult);

        return basicRes;
    }

}
