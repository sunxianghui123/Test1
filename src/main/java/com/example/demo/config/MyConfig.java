package com.example.demo.config;


import com.example.demo.interceptor.LoginHandlerInterceptor;
import component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/login.html","/user/login","/","/asserts/**");
    }

    @Bean
    public LocaleResolver localeResolver()
    {
        return new MyLocalResolver();
    }
}
