package cn.iris.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 返回状态枚举
 * @author Iris 2022/4/19
 */
@ToString
@Getter
@AllArgsConstructor
public enum RespBeanEnum {
    // 通用状态码
    SUCCESS(200,"success"),
    ERROR(500,"Server Error"),
    // 登录模块5002XX
    SESSION_ERROR(500210,"session不存在或已失效"),
    LOGIN_ERROR(500211,"用户名或密码错误"),
    MOBILE_ERROR(500212,"手机号码格式错误");

    private final Integer code;
    private final String message;
}
