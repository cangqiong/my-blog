package com.chason.blog.exception;

/**
 * 没有登录错误
 *
 * @author cang
 * @date 2017-10-08
 */
public class NotLoginException extends AppBaseException {

    public NotLoginException(String code, String message) {
        super(code, message);
    }

    public NotLoginException() {
        super();
    }

    public NotLoginException(String message) {
        super(message);
    }
}
