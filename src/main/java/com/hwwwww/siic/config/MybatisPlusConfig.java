package com.hwwwww.siic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Admin
 */
@Configuration
@MapperScan("com.hwwwww.siic.mapper")
@EnableConfigurationProperties(MybatisPlusConfig.class)
@ConfigurationProperties(prefix = "mp-config")
public class MybatisPlusConfig {
}
