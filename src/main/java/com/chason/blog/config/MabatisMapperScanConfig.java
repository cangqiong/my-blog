package com.chason.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * Mybatis扫描配置文件
 *
 * @author cang
 * @date 2017-10-07
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MabatisMapperScanConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.chason.blog.mapper");
        return mapperScannerConfigurer;
    }
}
