package com.cang.blog.model;

import javax.persistence.*;

@Table(name = "blog_todolist")
public class BlogTodolist {
    /**
     * TodoList ID
     */
    @Id
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * TodoList内容
     */
    private String content;

    /**
     * TodoList状态,默认值0为未删除，1为删除
     */
    private String status;

    /**
     * 获取TodoList ID
     *
     * @return id - TodoList ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置TodoList ID
     *
     * @param id TodoList ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取TodoList内容
     *
     * @return content - TodoList内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置TodoList内容
     *
     * @param content TodoList内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取TodoList状态,默认值0为未删除，1为删除
     *
     * @return status - TodoList状态,默认值0为未删除，1为删除
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置TodoList状态,默认值0为未删除，1为删除
     *
     * @param status TodoList状态,默认值0为未删除，1为删除
     */
    public void setStatus(String status) {
        this.status = status;
    }
}