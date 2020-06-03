package com.shanezhou.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @Author shaneZhou
 * @Time 2020/05/30 17:50 下午
 */
@Configuration
public class MyViewResolverConfiguration {

    @Bean
    public ViewResolver getViewResolver() {
        return new MyViewResolver();
    }


    private static class MyViewResolver implements ViewResolver {

        @Nullable
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
