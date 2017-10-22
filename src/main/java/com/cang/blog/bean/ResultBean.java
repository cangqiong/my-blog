package com.cang.blog.bean;

import com.cang.blog.constant.SystemConstantEnum;

import java.io.Serializable;

/**
 * 基本响应类
 *
 * @author cang
 * @date 2017-10-08
 */
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 9166790951642352943L;

    private int code;

    private String msg;

    private T data;

    public ResultBean() {
        this.code = SystemConstantEnum.SUCCESS.getCode();
        this.msg = SystemConstantEnum.SUCCESS.getMsg();
    }

    public ResultBean(T data) {
        this.code = SystemConstantEnum.SUCCESS.getCode();
        this.msg = SystemConstantEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}