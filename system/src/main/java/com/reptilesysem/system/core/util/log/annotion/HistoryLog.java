package com.reptilesysem.system.core.util.log.annotion;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HistoryLog {

    String path() default "";

    boolean save() default true;
}
