package com.example.argumentresolverplayground.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomPathVariable {
    /**
     * URI 템플릿 변수의 이름을 지정합니다.
     */
    String value();
}
