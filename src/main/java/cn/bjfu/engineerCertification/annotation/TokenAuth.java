package cn.bjfu.engineerCertification.annotation;

import java.lang.annotation.*;

/**
 * Created by jxy on 2021/4/19 0019 16:49
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenAuth {
    boolean value() default false;
}
