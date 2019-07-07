package com.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
* 配置静态资源路径
* */
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
        *
        * */
        //静态页面的目标地址
        registry.addResourceHandler("/**")
                //实际静态资源的存放地址
                .addResourceLocations("classpath:/static/");
    }
}
