package com.study.watermelon.configure;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    private String resourcePath = "/upload/**";

    private String savePath = "file:///C:/Users/cabin3613/Desktop/watermelon/src/main/resources/upload_files/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(resourcePath).addResourceLocations(savePath);
    }
}
