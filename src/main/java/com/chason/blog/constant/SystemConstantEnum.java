package com.chason.blog.constant;

/**
 * 代码常量
 *
 * @author cang
 * @date 2017-10-08
 */
public enum SystemConstantEnum {

    SUCCESS("000000", "响应成功"),
    USER_NOT_FOUND("400000", "用户不存在"),
    NOT_LOGIN("400001", "请登陆之后进行操作"),
    ADD_FAIURE("400002", "新增失败"),
    UPDATE_FAIURE("400003", "更新失败"),
    QUERY_FAIURE("400004", "查询失败"),
    DELETE_FAIURE("400005", "删除失败"),
    PASS_NOT_CORRECT("400006", "密码不正确"),
    SYSTEM_ERROR("999999", "系统错误");

    private String code;
    private String msg;

    SystemConstantEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getCodeByMsg(String msg) {
        for (SystemConstantEnum codeConstantEnum : SystemConstantEnum.values()) {
            if (codeConstantEnum.getMsg().equals(msg)) {
                return codeConstantEnum.getCode();
            }
        }
        return "-1";
    }

    public static String getMsgByCode(String code) {
        for (SystemConstantEnum systemConstantEnum : SystemConstantEnum.values()) {
            if (systemConstantEnum.getCode() == code) {
                return systemConstantEnum.getMsg();
            }
        }
        return "无法找到该代码对应的消息";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
