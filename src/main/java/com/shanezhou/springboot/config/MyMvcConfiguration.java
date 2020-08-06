package com.shanezhou.springboot.config;

import com.shanezhou.springboot.component.LoginHandlerIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 用于扩展SpringMVC的功能
 * @Author shaneZhou
 * @Time 2020/05/30 18:47 下午
 */
@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    /**
     * 国际化语言
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolverConfiguration();
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(new LoginHandlerIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index", "/user/login", "/index.html", "/webjars/**", "/assets/**")
                .excludePathPatterns("/hello/**", "/testpoi.html");
    }


}
