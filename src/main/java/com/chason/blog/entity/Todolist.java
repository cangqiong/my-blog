package com.chason.blog.entity;

import java.util.Date;
import javax.persistence.*;

public class Todolist {
    /**
     * TodoList ID
     */
    @Id
    @Column(name = "todolist_id")
    private Integer todolistId;

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
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 获取TodoList ID
     *
     * @return todolist_id - TodoList ID
     */
    public Integer getTodolistId() {
        return todolistId;
    }

    /**
     * 设置TodoList ID
     *
     * @param todolistId TodoList ID
     */
    public void setTodolistId(Integer todolistId) {
        this.todolistId = todolistId;
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

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否删除
     *
     * @return is_deleted - 是否删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除
     *
     * @param isDeleted 是否删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}