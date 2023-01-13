package com.cj.core.util.excle;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelField {
    /**
     * 列名
     * @return
     */
    String value() default "未知列名";

    boolean flag() default false;

    String className() default "";
}
