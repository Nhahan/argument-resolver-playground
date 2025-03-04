package com.example.argumentresolverplayground.resolver;

import com.example.argumentresolverplayground.annotation.CustomSessionAttribute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CustomSessionAttributeArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // CustomSessionAttribute 어노테이션이 존재하면 true (true 시 동작)
        return parameter.hasParameterAnnotation(CustomSessionAttribute.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {
        CustomSessionAttribute annotation = parameter.getParameterAnnotation(CustomSessionAttribute.class);
        if (annotation != null) {
            String attributeName = annotation.value();
            HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
            if (request != null) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    return session.getAttribute(attributeName);
                }
            }
        }
        return null;
    }
}
