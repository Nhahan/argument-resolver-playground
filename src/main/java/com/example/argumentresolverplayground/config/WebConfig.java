package com.example.argumentresolverplayground.config;

import com.example.argumentresolverplayground.resolver.CustomPathVariableArgumentResolver;
import com.example.argumentresolverplayground.resolver.CustomRequestParamArgumentResolver;
import com.example.argumentresolverplayground.resolver.CustomSessionAttributeArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CustomSessionAttributeArgumentResolver());
        resolvers.add(new CustomRequestParamArgumentResolver());
        resolvers.add(new CustomPathVariableArgumentResolver());
    }
}
