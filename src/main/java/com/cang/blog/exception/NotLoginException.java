package com.cang.blog.exception;

/**
 * 没有登录错误
 *
 * @author cang
 * @date 2017-10-08
 */
public class NotLoginException extends AppBaseException {

    public NotLoginException(int code, String message) {
        super(code, message);
    }

    public NotLoginException() {
        super();
    }

    public NotLoginException(String message) {
        super(message);
    }
}
