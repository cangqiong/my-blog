package com.cang.blog.bean;

import com.cang.blog.constant.CodeConstantEnum;

import java.io.Serializable;

/**
 * 基本响应类
 *
 * @author cang
 * @date 2017-10-08
 */
public class BasicRes<T> implements Serializable {

    private static final long serialVersionUID = 9166790951642352943L;

    private int code;

    private String msg;

    private T data;

    public BasicRes() {
        this.code = CodeConstantEnum.SUCCESS.getCode();
        this.msg = CodeConstantEnum.SUCCESS.getMsg();
    }

    public BasicRes(T data) {
        this.code = CodeConstantEnum.SUCCESS.getCode();
        this.msg = CodeConstantEnum.SUCCESS.getMsg();
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
