package com.chason.blog.controller;

import com.chason.blog.bean.ResultBean;
import com.chason.blog.bean.req.UserLoginReq;
import com.chason.blog.constant.SystemConstantEnum;
import com.chason.blog.service.IUserService;
import com.chason.blog.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IUserService blogUserService;

    @RequestMapping( "/setcookie" )
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

        String error = blogUserService.validate(userLoginReq.getUsername(), userLoginReq.getPassword());
        // 登录成功
        if (StringUtils.isEmpty(error)) {
            // 生成JWT的Token
            String token = jwtTokenUtil.generateToken(userLoginReq.getUsername());
            result.setData(token);

            // 登录成功设置cookie
            response.addCookie(getJwtCookie(userLoginReq.getUsername(), token));
        } else {
            result.setMsg(error);
            result.setCode(SystemConstantEnum.getCodeByMsg(error));
        }

        return result;
    }

    private Cookie getJwtCookie(String username, String token) {

        Cookie cookie = new Cookie("jwtToken", token);
        //设置cookie的过期时间是5min
        cookie.setMaxAge(5 * 60);
        cookie.setHttpOnly(true);
        cookie.setPath("/todolist");
        return cookie;
    }

//    /**
//     * 用户登录
//     *
//     * @return
//     */
//    @RequestMapping(value = "/auth", method = RequestMethod.POST)
//    public UserLoginRes login(@RequestBody @Valid UserLoginReq userLoginReq) {
//
//        UserLoginRes userLoginRes = new UserLoginRes();
//
//        String error = blogUserService.validate(userLoginReq.getUsername(), userLoginReq.getPassword());
//
//        // 登录成功
//        if (StringUtils.isEmpty(error)) {
//            // 生成JWT的Token
//            String token = jwtTokenUtil.generateToken(userLoginReq.getUsername());
//            userLoginRes.setData(token);
//        } else {
//            userLoginRes.setMsg(error);
//            userLoginRes.setCode(SystemConstantEnum.getCodeByMsg(error));
//        }
//
//        return userLoginRes;
//    }

}
