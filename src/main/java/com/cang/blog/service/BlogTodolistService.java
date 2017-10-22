package com.cang.blog.service;

import com.cang.blog.annotation.Authorization;
import com.cang.blog.bean.PageReq;
import com.cang.blog.bean.QueryResult;
import com.cang.blog.exception.UserNotFoundException;
import com.cang.blog.mapper.BlogTodolistMapper;
import com.cang.blog.mapper.BlogUserMapper;
import com.cang.blog.model.BlogTodolist;
import com.cang.blog.model.BlogUser;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.cang.blog.constant.SystemConstantEnum.USER_NOT_FOUND;

/**
 * Todolit服务实现类
 *
 * @author cang
 * @date 2017-10-08
 */
@Service
public class BlogTodolistService implements IBlogTodolistService {

    @Autowired
    private BlogUserMapper userMapper;

    @Autowired
    private BlogTodolistMapper blogTodolistMapper;

    @Override
    @Transactional
    @Authorization
    public boolean add(String userName, String content) throws UserNotFoundException {

        BlogUser user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMsg());
        }

        BlogTodolist blogTodolist = new BlogTodolist();
        blogTodolist.setUserId(user.getId());
        blogTodolist.setContent(content);

        int insertCount = blogTodolistMapper.insertSelective(blogTodolist);

        return insertCount == 1;
    }

    @Override
    @Transactional
    public boolean update(int todoListId, String userName, String content) throws UserNotFoundException {

        BlogUser user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMsg());
        }

        BlogTodolist blogTodolist = blogTodolistMapper.selectByPrimaryKey(todoListId);
        blogTodolist.setContent(content);

        int updateCount = blogTodolistMapper.updateByPrimaryKeySelective(blogTodolist);

        return updateCount == 1;
    }

    @Override
    @Transactional
    public boolean delete(int todoListId, String userName) throws UserNotFoundException {

        BlogUser user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMsg());
        }

        int deleteCount = blogTodolistMapper.deleteByPrimaryKey(todoListId);

        return deleteCount == 1;
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<BlogTodolist> query(String userName, PageReq pageReq) throws UserNotFoundException {

        BlogUser user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMsg());
        }

        QueryResult<BlogTodolist> queryResult = new QueryResult<BlogTodolist>();

        BlogTodolist blogTodolist = new BlogTodolist();
        blogTodolist.setUserId(user.getId());

        queryResult.setCount(getCount(blogTodolist, user));
        RowBounds rowBounds = getRowBounds(pageReq);
        List<BlogTodolist> queryBlogTodoLists = blogTodolistMapper.selectByRowBounds(blogTodolist, rowBounds);

        queryResult.setRecords(queryBlogTodoLists);

        return queryResult;
    }

    @Override
    public BlogTodolist queryById(Integer listId) {
        return blogTodolistMapper.selectByPrimaryKey(listId);
    }

    /**
     * 获取该用户下的所有TodoList的总数
     *
     * @param blogTodolist
     * @param user
     * @return
     */
    private int getCount(BlogTodolist blogTodolist, BlogUser user) {

        return blogTodolistMapper.selectCount(blogTodolist);
    }

    /**
     * 获取Mybatis的行查询的区间
     *
     * @param pageReq
     * @return
     */
    private RowBounds getRowBounds(PageReq pageReq) {

        // 没有分页信息，默认返回前10条数据
        if (pageReq == null) {
            return new RowBounds(0, 10);
        }
        if (pageReq.getPageNum() == null || pageReq.getPageNum() <= 0) {
            pageReq.setPageNum(1);
        }

        if (pageReq.getPageSize() == null) {
            pageReq.setPageSize(10);
        }

        int offset = (pageReq.getPageNum() - 1) * pageReq.getPageSize();
        int limit = offset + pageReq.getPageSize();

        return new RowBounds(offset, limit);
    }
}
