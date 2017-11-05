package com.chason.blog.service;

import com.chason.blog.bean.PageReq;
import com.chason.blog.bean.QueryResult;
import com.chason.blog.entity.Todolist;
import com.chason.blog.exception.UserNotFoundException;

/**
 * TodoList服务接口类
 *
 * @author cang
 * @date 2017-10-08
 */
public interface ITodolistService {

    boolean add(String userName, String content) throws UserNotFoundException;

    boolean update(int todoListId, String userName, String content) throws UserNotFoundException;

    boolean delete(int todoListId, String userName) throws UserNotFoundException;

    QueryResult<Todolist> query(String userName, PageReq pageReq) throws UserNotFoundException;

    Todolist queryById(Integer listId);
}
