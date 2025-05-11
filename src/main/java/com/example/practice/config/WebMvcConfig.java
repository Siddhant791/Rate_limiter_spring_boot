package com.example.practice.config;

import com.example.practice.interceptor.RateLimiterInterceptor; // Importing the custom interceptor for rate limiting
import com.example.practice.services.RateLimiterService; // Importing the service that handles rate limiting logic
import org.springframework.context.annotation.Configuration; // Annotation to mark this class as a Spring configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry; // Used to register interceptors
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // Interface to customize Spring MVC configuration

@Configuration // Marks this class as a configuration class for Spring
public class WebMvcConfig implements WebMvcConfigurer {

    private final RateLimiterService rateLimiterService; // Service to handle rate limiting logic

    /**
     * Constructor to inject the RateLimiterService dependency.
     *
     * @param rateLimiterService the service that provides rate limiting functionality
     */
    public WebMvcConfig(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService; // Initialize the rate limiter service
    }

    /**
     * Registers the RateLimiterInterceptor to intercept requests and apply rate limiting.
     *
     * @param interceptorRegistry the registry to add interceptors
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new RateLimiterInterceptor(rateLimiterService)) // Add the rate limiter interceptor
                .addPathPatterns("/"); // Apply the interceptor to the root path
    }
}