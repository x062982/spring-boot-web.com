package com.shanezhou.springboot.config;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在链接上携带区域信息
 * @Author shaneZhou
 * @Time 2020/05/30 20:25 下午
 */
public class MyLocaleResolverConfiguration implements LocaleResolver{

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse, @Nullable Locale locale) {

    }
}
