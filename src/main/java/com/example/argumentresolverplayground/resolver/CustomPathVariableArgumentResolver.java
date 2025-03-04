package com.example.argumentresolverplayground.resolver;

import com.example.argumentresolverplayground.annotation.CustomPathVariable;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

public class CustomPathVariableArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean supports = parameter.hasParameterAnnotation(CustomPathVariable.class);
        System.out.println("CustomPathVariableArgumentResolver.supportsParameter: " + supports);
        return supports;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        System.out.println("CustomPathVariableArgumentResolver.resolveArgument called");
        CustomPathVariable annotation = parameter.getParameterAnnotation(CustomPathVariable.class);
        if (annotation == null) {
            System.out.println("No annotation found");
            return null;
        }
        String variableName = annotation.value();
        System.out.println("Variable name: " + variableName);
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if (request == null) {
            System.out.println("No HttpServletRequest found");
            return null;
        }
        @SuppressWarnings("unchecked")
        Map<String, String> uriTemplateVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if (uriTemplateVars == null) {
            System.out.println("No URI template variables found");
            return null;
        }
        String result = uriTemplateVars.get(variableName);
        System.out.println("Resolved value: " + result);
        return result;
    }
}
