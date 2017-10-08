package com.cang.blog.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author cang
 * @date 2017-10-08
 */
public class UpdateTodoListReq implements Serializable {

    private static final long serialVersionUID = -4654306523915703977L;

    @NotNull(message = "todoListId不能为空")
    private Integer todoListId;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "Todolist内容不为空")
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
