package com.cang.blog.exception;

/**
 * @author cang
 * @date 2017-10-08
 */
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7304279774991505938L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
