package com.example.practice.config;

import com.example.practice.interceptor.RateLimiterInterceptor;
import com.example.practice.services.RateLimiterService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final RateLimiterService rateLimiterService;

    public WebMvcConfig(RateLimiterService rateLimiterService){
        this.rateLimiterService = rateLimiterService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(new RateLimiterInterceptor(rateLimiterService))
                .addPathPatterns("/");
    }


}
