package com.hwwwww.siic.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * <p>自定义组合注解</p>
 * <p>ResponseBody详细见:{@link ResponseBody @ResponseBody }</p>
 * <p>RequestMapping详细见:{@link RequestMapping @RequestMapping }</p>
 *
 * @author Hwwwww
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ResponseBody
@RequestMapping
public @interface RespBodyResMapping {
    @AliasFor("path")
    String[] value() default {};

    @AliasFor("value")
    String[] path() default {};
}
