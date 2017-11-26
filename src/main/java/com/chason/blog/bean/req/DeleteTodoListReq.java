package com.chason.blog.bean.req;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 删除Todolist请求
 *
 * @author cang
 * @date 2017-10-08
 */
public class DeleteTodoListReq implements Serializable {

    private static final long serialVersionUID = -2626302954425383793L;

    @NotNull(message = "TodoList id不能为空")
    private Integer todoListId;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    public Integer getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(Integer todoListId) {
        this.todoListId = todoListId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
