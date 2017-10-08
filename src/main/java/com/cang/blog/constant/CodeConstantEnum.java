package com.cang.blog.constant;

/**
 * 代码常量
 *
 * @author cang
 * @date 2017-10-08
 */
public enum CodeConstantEnum {

    SUCCESS(200, "响应成功"),
    USER_NOT_FOUND(400, "Not found the user"),
    PASS_NOT_CORRECT(401, "密码不正确");

    private int code;
    private String msg;

    CodeConstantEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static int getCodeByMsg(String msg) {
        for (CodeConstantEnum codeConstantEnum : CodeConstantEnum.values()) {
            if (codeConstantEnum.getMsg().equals(msg)) {
                return codeConstantEnum.getCode();
            }
        }
        return -1;
    }

    public static String getMsgByCode(int code) {
        for (CodeConstantEnum codeConstantEnum : CodeConstantEnum.values()) {
            if (codeConstantEnum.getCode() == code) {
                return codeConstantEnum.getMsg();
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
