package com.chason.blog.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author cang
 * @date 2017-10-08
 */
public class UserLoginReq {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    // 验证码
    private String VerifCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifCode() {
        return VerifCode;
    }

    public void setVerifCode(String verifCode) {
        VerifCode = verifCode;
    }
}
