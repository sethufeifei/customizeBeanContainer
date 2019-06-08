package com.study;

import java.lang.annotation.*;

/**
 * @author fei
 * @version V1.0
 * @date 2019/06/08 12:41
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value();
}
