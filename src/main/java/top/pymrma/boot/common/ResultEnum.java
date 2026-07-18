package top.pymrma.boot.common;

public enum ResultEnum {
    // 成功
    SUCCESS(0, "success"),

    // 通用
    SYSTEM_ERROR(5000, "系统异常"),
    PARAM_ERROR(4000, "请求参数错误"),
    NOT_FOUND(4004, "资源不存在"),
    METHOD_NOT_ALLOWED(4005, "请求方法不允许"),

    // 登录认证
    UNAUTHORIZED(1001, "未登录"),
    FORBIDDEN(1002, "无权限"),
    LOGIN_FAILED(1003, "用户名或密码错误"),
    TOKEN_INVALID(1004, "Token无效"),
    TOKEN_EXPIRED(1005, "Token已过期"),

    // 用户
    USER_NOT_FOUND(2001, "用户不存在"),
    USER_EXIST(2002, "用户已存在"),
    OLD_PASSWORD_ERROR(2003, "原密码错误"),
    PASSWORD_NOT_MATCH(2004, "两次密码不一致"),

    // 数据
    DATA_NOT_FOUND(3001, "数据不存在"),
    DATA_EXIST(3002, "数据已存在"),
    DATABASE_ERROR(3003, "数据库操作失败"),

    // 文件
    FILE_UPLOAD_ERROR(4001, "文件上传失败"),
    FILE_NOT_FOUND(4002, "文件不存在"),
    FILE_TYPE_ERROR(4003, "文件类型错误"),

    // 第三方
    THIRD_SERVICE_ERROR(5001, "第三方服务异常"),
    NETWORK_ERROR(5002, "网络异常"),

    // 限流
    TOO_MANY_REQUEST(6001, "请求过于频繁");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
