package com.cang.blog.controller;

import com.cang.blog.annotation.Authorization;
import com.cang.blog.bean.*;
import com.cang.blog.model.BlogTodolist;
import com.cang.blog.service.IBlogTodolistService;
import com.cang.blog.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * TodoList控制器
 *
 * @author cang
 * @date 2017-10-07
 */
@RestController
@RequestMapping("/todoList")
public class TodolistController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IBlogTodolistService todolistService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Authorization
    public ResultBean<Boolean> addTodoList(@RequestBody @Valid AddTodoListReq addTodoListReq) throws Exception {

        ResultBean<Boolean> basicRes = new ResultBean<>();

        Boolean result = todolistService.add(addTodoListReq.getUserName(), addTodoListReq.getContent());

        basicRes.setData(result);

        return basicRes;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Authorization
    public ResultBean<Boolean> updateTodoList(@RequestBody @Valid UpdateTodoListReq updateTodoListReq) throws Exception {

        ResultBean<Boolean> basicRes = new ResultBean<>();

        Boolean result = todolistService.update(updateTodoListReq.getTodoListId(), updateTodoListReq.getUserName(), updateTodoListReq.getContent());

        basicRes.setData(result);

        return basicRes;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Authorization
    public ResultBean<Boolean> deleteTodoList(@RequestBody @Valid DeleteTodoListReq deleteTodoListReq) throws Exception {

        ResultBean<Boolean> basicRes = new ResultBean<>();

        Boolean result = todolistService.delete(deleteTodoListReq.getTodoListId(), deleteTodoListReq.getUserName());

        basicRes.setData(result);

        return basicRes;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @Authorization
    public ResultBean<QueryResult<BlogTodolist>> queryTodoList(@Valid QueryTodoListReq queryTodoListReq) throws Exception {

        ResultBean<QueryResult<BlogTodolist>> basicRes = new ResultBean<>();

        QueryResult<BlogTodolist> queryResult = todolistService.query(queryTodoListReq.getUserName(), queryTodoListReq.getPageReq());

        basicRes.setData(queryResult);

        return basicRes;
    }

    @RequestMapping(value = "/query/{listId}", method = RequestMethod.GET)
    @Authorization
    public ResultBean<BlogTodolist> queryTodoList(@NotNull @PathVariable("listId") Integer listId) throws Exception {

        ResultBean<BlogTodolist> basicRes = new ResultBean<>();

        BlogTodolist queryResult = todolistService.queryById(listId);

        basicRes.setData(queryResult);

        return basicRes;
    }

}
