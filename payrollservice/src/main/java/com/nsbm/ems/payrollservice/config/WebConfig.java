package com.nsbm.ems.payrollservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // This will match all API endpoints under "/api"
                .allowedOrigins("http://localhost:3000")  // Allow React frontend at this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // HTTP methods you want to allow
                .allowedHeaders("*")  // Allow any headers
                .allowCredentials(true);  // Allow credentials (like cookies, authorization headers)
    }
}