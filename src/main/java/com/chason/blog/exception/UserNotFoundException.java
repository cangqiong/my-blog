package com.chason.blog.exception;

/**
 * 用户无法找到时抛出该异常
 *
 * @author cang
 * @date 2017-10-08
 */
public class UserNotFoundException extends AppBaseException {

    private static final long serialVersionUID = 1923912283062464628L;

    public UserNotFoundException(String code, String message) {
        super(code, message);
    }

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
