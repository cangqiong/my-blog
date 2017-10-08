package com.cang.blog.controller;

import com.cang.blog.bean.UserLoginReq;
import com.cang.blog.bean.UserLoginRes;
import com.cang.blog.constant.CodeConstantEnum;
import com.cang.blog.mapper.BlogUserMapper;
import com.cang.blog.model.BlogUser;
import com.cang.blog.service.IBlogUserService;
import com.cang.blog.util.JwtTokenUtil;
import com.sun.tools.javac.jvm.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户登录控制器
 *
 * @author cang
 * @date 2017-10-07
 */
@RestController("/user")
public class UserLoginController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IBlogUserService blogUserService;

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserLoginRes login(@RequestBody @Valid UserLoginReq userLoginReq) {

        UserLoginRes userLoginRes = new UserLoginRes();

        String error = blogUserService.validate(userLoginReq.getUsername(), userLoginReq.getPassword());

        // 登录成功
        if (StringUtils.isEmpty(error)) {
            // 生成JWT的Token
            String token = jwtTokenUtil.generateToken(userLoginReq.getUsername());
            userLoginRes.setData(token);
        } else {
            userLoginRes.setMsg(error);
            userLoginRes.setCode(CodeConstantEnum.getCodeByMsg(error));
        }

        return userLoginRes;
    }

}
