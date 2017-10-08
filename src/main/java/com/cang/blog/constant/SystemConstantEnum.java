package com.cang.blog.constant;

/**
 * 代码常量
 *
 * @author cang
 * @date 2017-10-08
 */
public enum SystemConstantEnum {

    SUCCESS(200, "响应成功"),
    USER_NOT_FOUND(400, "用户不存在"),
    NOT_LOGIN(401, "请登陆之后进行操作"),
    PASS_NOT_CORRECT(402, "密码不正确");

    private int code;
    private String msg;

    SystemConstantEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static int getCodeByMsg(String msg) {
        for (SystemConstantEnum codeConstantEnum : SystemConstantEnum.values()) {
            if (codeConstantEnum.getMsg().equals(msg)) {
                return codeConstantEnum.getCode();
            }
        }
        return -1;
    }

    public static String getMsgByCode(int code) {
        for (SystemConstantEnum systemConstantEnum : SystemConstantEnum.values()) {
            if (systemConstantEnum.getCode() == code) {
                return systemConstantEnum.getMsg();
            }
        }
        return "无法找到该代码对应的消息";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
