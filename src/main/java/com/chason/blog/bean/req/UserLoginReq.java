package com.chason.blog.bean.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author cang
 * @date 2017-10-08
 */
public class UserLoginReq {

    @NotBlank( message = "用户名不能为空" )
    private String userName;

    @NotBlank( message = "密码不能为空" )
    private String password;

    // 验证码
    private String verifCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifCode() {
        return verifCode;
    }

    public void setVerifCode(String verifCode) {
        this.verifCode = verifCode;
    }
}
