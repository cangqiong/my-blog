package com.chason.blog.service;

import com.chason.blog.annotation.Authorization;
import com.chason.blog.bean.PageReq;
import com.chason.blog.bean.QueryResult;
import com.chason.blog.constant.SystemConstantEnum;
import com.chason.blog.entity.Todolist;
import com.chason.blog.entity.User;
import com.chason.blog.exception.UserNotFoundException;
import com.chason.blog.mapper.TodolistMapper;
import com.chason.blog.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Todolit服务实现类
 *
 * @author cang
 * @date 2017-10-08
 */
@Service
public class TodolistService implements ITodolistService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TodolistMapper todolistMapper;

    @Override
    @Transactional
    @Authorization
    public boolean add(String userName, String content) throws UserNotFoundException {

        User user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(SystemConstantEnum.USER_NOT_FOUND.getCode(), SystemConstantEnum.USER_NOT_FOUND.getMsg());
        }

        Todolist blogTodolist = new Todolist();
        blogTodolist.setUserId(user.getUserId());
        blogTodolist.setContent(content);

        int insertCount = todolistMapper.insertSelective(blogTodolist);

        return insertCount == 1;
    }

    @Override
    @Transactional
    public boolean update(int todoListId, String userName, String content) throws UserNotFoundException {

        User user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(SystemConstantEnum.USER_NOT_FOUND.getCode(), SystemConstantEnum.USER_NOT_FOUND.getMsg());
        }

        Todolist blogTodolist = todolistMapper.selectByPrimaryKey(todoListId);
        blogTodolist.setContent(content);

        int updateCount = todolistMapper.updateByPrimaryKeySelective(blogTodolist);

        return updateCount == 1;
    }

    @Override
    @Transactional
    public boolean delete(int todoListId, String userName) throws UserNotFoundException {

        User user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(SystemConstantEnum.USER_NOT_FOUND.getCode(), SystemConstantEnum.USER_NOT_FOUND.getMsg());
        }

        int deleteCount = todolistMapper.deleteByPrimaryKey(todoListId);

        return deleteCount == 1;
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<Todolist> query(String userName, PageReq pageReq) throws UserNotFoundException {

        User user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(SystemConstantEnum.USER_NOT_FOUND.getCode(), SystemConstantEnum.USER_NOT_FOUND.getMsg());
        }

        QueryResult<Todolist> queryResult = new QueryResult<Todolist>();

        Todolist blogTodolist = new Todolist();
        blogTodolist.setUserId(user.getUserId());

        queryResult.setCount(getCount(blogTodolist, user));
        RowBounds rowBounds = getRowBounds(pageReq);
        List<Todolist> queryBlogTodoLists = todolistMapper.selectByRowBounds(blogTodolist, rowBounds);

        queryResult.setRecords(queryBlogTodoLists);

        return queryResult;
    }

    @Override
    public Todolist queryById(Integer listId) {
        return todolistMapper.selectByPrimaryKey(listId);
    }

    /**
     * 获取该用户下的所有TodoList的总数
     *
     * @param blogTodolist
     * @param user
     * @return
     */
    private int getCount(Todolist blogTodolist, User user) {

        return todolistMapper.selectCount(blogTodolist);
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
