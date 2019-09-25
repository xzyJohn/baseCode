package com.xzy.basis.core.annotation;

import java.lang.annotation.*;

/**
 * @author xzy
 * @date 2019/9/10 15:11
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    /**
     * 日志描述
     * 例如：新增用户
     * @return
     */
    String value() default "";

    /**
     * 日志描述
     * 例如：新增用户
     * @return
     */
    String desc() default "";
}
