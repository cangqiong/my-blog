package com.chason.blog.exception;

/**
 * 基础异常类，所有异常都必须继承该类
 *
 * @author cang
 * @date 2017-10-08
 */
public class AppBaseException extends RuntimeException {

    private static final long serialVersionUID = 5678142353787803120L;

    //异常对应的返回码
    private String code;
    //异常对应的描述信息
    private String message;

    public AppBaseException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public AppBaseException() {
        super();
    }

    public AppBaseException(String message) {
        super(message);
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}