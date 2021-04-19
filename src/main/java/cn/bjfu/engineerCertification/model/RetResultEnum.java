package cn.bjfu.engineerCertification.model;

/**
 * Created by jxy on 2021/4/19 0019 16:48
 */
public enum RetResultEnum {
    /** 接口调用成功 */
    RET_SUCCESS(200, "接口调用成功"),
    /** 用户未登录 */
    USER_NOT_LOGIN(20012, "用户未登录"),

    /** 用户不存在 */
    USER_PASSWORLD_NOT_MATCH(30010, "用户名或者密码错误"),

    /** 参数缺失 */
    ARGS_MISS(40000, "参数缺失"),
    /** 参数缺失 */
    LOGIN_FAIL(40001, "登录失败"),
    /** 参数缺失 */
    TOKEN_FAIL(40002, "认证失败"),
    /** 没有权限 */
    NO_POWER(40003, "没有权限"),
    /** 没有权限 */
    JWT_ERROR(40004, "JWT错误"),

    /** 结果为空 */
    NO_DATA(5000, "结果为空"),

    /** 业务处理失败 */
    ERROR(400, "业务处理失败"),
    /** 系统出现异常 */
    SYSTEM_ERROR(401, "系统出现异常"),
    ;
    private Integer retCode;
    private String retDesc;

    RetResultEnum(Integer retCode, String retDesc) {
        this.retCode = retCode;
        this.retDesc = retDesc;
    }

    public int getRetCode() {
        return retCode;
    }

    public String getRetDesc() {
        return retDesc;
    }
}
