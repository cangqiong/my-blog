package com.chason.blog.bean;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 查询Todolist请求
 *
 * @author cang
 * @date 2017-10-08
 */
public class QueryTodoListReq implements Serializable {

    private static final long serialVersionUID = -7127870426167773222L;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    // 分页信息
    private PageReq pageReq;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PageReq getPageReq() {
        return pageReq;
    }

    public void setPageReq(PageReq pageReq) {
        this.pageReq = pageReq;
    }
}
