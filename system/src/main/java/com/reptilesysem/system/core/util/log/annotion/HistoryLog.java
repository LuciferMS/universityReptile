package com.reptilesysem.system.core.util.log.annotion;

public @interface HistoryLog {

    String value() default "";

    boolean save() default true;
}
