package com.chason.blog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在Controller层使用该注解，用于标记该方法是否需要用户登录，未登录返回401错误
 *
 * @author cang
 * @date 2017/10/8 10:23
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
}
