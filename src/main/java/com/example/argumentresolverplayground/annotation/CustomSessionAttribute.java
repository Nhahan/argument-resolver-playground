package com.example.argumentresolverplayground.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomSessionAttribute {
    /**
     * 세션에서 가져올 속성 이름
     */
    String value();
}
