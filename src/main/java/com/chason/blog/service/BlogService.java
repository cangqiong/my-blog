package com.chason.blog.service;

import com.chason.blog.bean.QueryResult;
import com.chason.blog.bean.req.AddBlogReq;
import com.chason.blog.bean.req.PageReq;
import com.chason.blog.bean.req.UpdateBlogReq;
import com.chason.blog.constant.SystemConstantEnum;
import com.chason.blog.entity.Blog;
import com.chason.blog.exception.BuinessException;
import com.chason.blog.mapper.BlogMapper;
import com.chason.blog.util.DateUtils;
import com.chason.blog.util.PageUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 博客服务实现类
 *
 * @author cang
 * @date 2017-10-08
 */
@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Transactional
    @Override
    public Integer saveBlog(AddBlogReq addBlogReq) {

        Blog blog = new Blog();
        blog.setBlogTitle(addBlogReq.getTitle());
        blog.setBlogContent(addBlogReq.getContent());
        blog.setCreateTime(DateUtils.getNow());
        blog.setModifyTime(DateUtils.getNow());
        if (addBlogReq.getCotentType() != null && blog.getContentType() == 1) {
            blog.setContentType(addBlogReq.getCotentType());
        }
        blogMapper.insertAndGetId(blog);

        return blog.getBlogId();
    }

    @Transactional
    @Override
    public void updateBlog(UpdateBlogReq updateBlogReq) {

        Blog blog = new Blog();
        blog.setBlogId(updateBlogReq.getBlogId());
        blog.setBlogTitle(updateBlogReq.getTitle());
        blog.setBlogContent(updateBlogReq.getContent());
        blog.setModifyTime(DateUtils.getNow());
        if (updateBlogReq.getCotentType() != null) {
            blog.setContentType(updateBlogReq.getCotentType());
        }

        int count = blogMapper.updateByPrimaryKeySelective(blog);
        if (count != 1) {
            throw new BuinessException(SystemConstantEnum.UPDATE_FAIURE.getCode(), SystemConstantEnum.UPDATE_FAIURE.getMsg());
        }

    }

    @Transactional
    @Override
    public void deleteBlog(Integer blogId) {

        int count = blogMapper.deleteByPrimaryKey(blogId);
        if (count != 1) {
            throw new BuinessException(SystemConstantEnum.DELETE_FAIURE.getCode(), SystemConstantEnum.DELETE_FAIURE.getMsg());
        }
    }

    @Transactional
    @Override
    public Blog queryBlogById(Integer blogId) {

        return blogMapper.selectByPrimaryKey(blogId);
    }

    @Transactional
    @Override
    public QueryResult<Blog> queryBlogList(PageReq pageReq) {

        QueryResult<Blog> queryResult = new QueryResult<>();

        Blog blog = new Blog();
        RowBounds rowBounds = PageUtils.getRowBounds(pageReq);

        List<Blog> blogList = blogMapper.selectByRowBounds(blog, rowBounds);
        queryResult.setRecords(blogList);
        int count = blogMapper.selectCount(blog);
        queryResult.setCount(count);

        return queryResult;
    }

    @Transactional
    @Override
    public QueryResult<Blog> queryBlogList(String searchKey, PageReq pageReq) {

        QueryResult<Blog> queryResult = new QueryResult<>();

        RowBounds rowBounds = PageUtils.getRowBounds(pageReq);

        List<Blog> blogList = blogMapper.searchByTitle(searchKey, rowBounds);

        queryResult.setRecords(blogList);
        int count = blogMapper.searchKeyCount(searchKey);
        queryResult.setCount(count);

        return queryResult;
    }
}
