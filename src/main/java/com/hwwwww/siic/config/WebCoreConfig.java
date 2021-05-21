package com.hwwwww.siic.config;


import com.hwwwww.siic.config.converter.DateToStringConverter;
import com.hwwwww.siic.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    private static final String[] ORIGINS = new String[]{"GET", "POST", "PUT", "DELETE"};
    public static final String[] WHITE_LIST = new String[]{
            "/user/register", "/user/login", "/user/logout", "/user/refresh-token", "/user/info",
            "/favicon.ico", "/error", "/static/**", "/assets/**", "/images/**", "/static/images/**"};
    public static final String[] BLACK_LIST = new String[]{""};
    private TokenInterceptor tokenInterceptor;

    //构造方法
    public WebCoreConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Autowired
    private DateToStringConverter dateToStringConverter;


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(tokenInterceptor).excludePathPatterns(WHITE_LIST).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateToStringConverter);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods(ORIGINS)
                .maxAge(3600);
    }
}
