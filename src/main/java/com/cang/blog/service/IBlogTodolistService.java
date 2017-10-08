package com.cang.blog.service;

import com.cang.blog.bean.PageReq;
import com.cang.blog.bean.QueryResult;
import com.cang.blog.exception.UserNotFoundException;
import com.cang.blog.model.BlogTodolist;

import java.util.List;

/**
 * TodoList服务接口类
 *
 * @author cang
 * @date 2017-10-08
 */
public interface IBlogTodolistService {

    boolean add(String userName, String content) throws UserNotFoundException;

    boolean update(int todoListId, String userName, String content) throws UserNotFoundException;

    boolean delete(int todoListId, String userName) throws UserNotFoundException;

    QueryResult<BlogTodolist> query(String userName, PageReq pageReq) throws UserNotFoundException;

}
