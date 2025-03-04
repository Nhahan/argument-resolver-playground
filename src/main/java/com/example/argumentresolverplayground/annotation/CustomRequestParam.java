package com.example.argumentresolverplayground.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomRequestParam {
    /**
     * 요청 파라미터의 이름을 지정합니다.
     */
    String value();
}
