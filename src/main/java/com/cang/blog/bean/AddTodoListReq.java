package com.cang.blog.bean;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 添加Todolist请求
 *
 * @author cang
 * @date 2017-10-08
 */
public class AddTodoListReq implements Serializable {

    private static final long serialVersionUID = -7007826762820198054L;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "Todolist内容不为空")
    private String content;

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
