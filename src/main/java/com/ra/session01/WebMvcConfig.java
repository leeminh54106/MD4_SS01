package com.ra.session01;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // cấu hình đường dẫn đến 1 view cố định không liên quan đến controller nào
        registry.addViewController("/hello").setViewName("hello");
    }
}
