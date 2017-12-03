package com.chason.blog.controller;

import com.chason.blog.bean.ResultBean;
import com.chason.blog.bean.req.UserLoginReq;
import com.chason.blog.service.IUserService;
import com.chason.blog.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 用户登录控制器
 *
 * @author cang
 * @date 2017-10-07
 */
@RestController
@RequestMapping( "/login" )
public class LoginController {

    // 最大cookie保存时间，以秒为单位
    private static int COOKIE_MAX_AGE = 60 * 60;

    @Value( "${jwt.header}" )
    private String jwtHeaderPrefix;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IUserService userService;

    @RequestMapping( "/setCookie" )
    public String setCookie(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie1 = new Cookie("cookie1", "value1");
        cookie1.setMaxAge(1800);
        Cookie cookie2 = new Cookie("cookie2", "value2");
        cookie2.setMaxAge(3600);
        cookie1.setPath(request.getContextPath());
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "cookie set ok";
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping( value = "/auth", method = RequestMethod.POST )
    public ResultBean<String> login(@RequestBody @Valid UserLoginReq userLoginReq, HttpServletRequest request, HttpServletResponse response) {

        ResultBean<String> result = new ResultBean<>();

        userService.validate(userLoginReq.getUserName(), userLoginReq.getPassword());

        // 登录成功,生成JWT的Token
        String token = jwtTokenUtil.generateToken(userLoginReq.getUserName());
        result.setData(token);

        // 登录成功设置cookie
        Cookie jwtCookie = getJwtCookie(token);
        response.addCookie(jwtCookie);

        return result;
    }

    private Cookie getJwtCookie(String token) {
        return getJwtCookie(jwtHeaderPrefix, "jwtToken" + token, COOKIE_MAX_AGE, "/");
    }

    private Cookie getJwtCookie(String cookieKey, String token, int maxAge, String path) {

        Cookie cookie = new Cookie(cookieKey, token);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(true);
        cookie.setPath(path);
        return cookie;
    }

}
