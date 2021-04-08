package com.hwwwww.siic.config;


import com.hwwwww.siic.interceptor.TokenInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * 处理跨域问题
 *
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/3/30 20:25
 */
@Configuration
public class WebCoreConfig implements WebMvcConfigurer {
    static final String[] ORIGINS = new String[]{"GET", "POST", "PUT", "DELETE"};

    private TokenInterceptor tokenInterceptor;

    //构造方法
//    public WebCoreConfig(TokenInterceptor tokenInterceptor) {
//        this.tokenInterceptor = tokenInterceptor;
//    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }

/*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        //排除拦截
        excludePath.add("/register");
        excludePath.add("/login");
        excludePath.add("/favicon.ico");
        excludePath.add("/error");
        excludePath.add("/static/**");
        excludePath.add("/assets/**");
        registry.addInterceptor(tokenInterceptor).excludePathPatterns(excludePath).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
*/


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods(ORIGINS)
                .maxAge(3600);
    }
}
