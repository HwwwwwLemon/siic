package com.hwwwww.siic.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 可以配置多个,设置setOrder([优先级])
 *
 * @author Hwwwww
 * @version JDK 13
 * @date 2021/3/30 20:12
 */
public class WebServletCoreConfig {
    @Bean
    public ServletRegistrationBean myServlet1() {
        return new ServletRegistrationBean<>();
    }

    @Bean
    public FilterRegistrationBean myFilter1() {
        return new FilterRegistrationBean<>();
    }

    @Bean
    public ServletListenerRegistrationBean myListener1() {
        return new ServletListenerRegistrationBean<>();
    }
}
