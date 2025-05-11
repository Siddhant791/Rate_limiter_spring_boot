package com.example.practice.interceptor;

import com.example.practice.services.RateLimiterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class RateLimiterInterceptor implements HandlerInterceptor {
    private final RateLimiterService rateLimiterService;

    public RateLimiterInterceptor(RateLimiterService rateLimiterService){
        this.rateLimiterService = rateLimiterService;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object handler) throws Exception {
        String clientId = httpServletRequest.getRemoteAddr();
        if(!rateLimiterService.allowRequest(clientId)){
            httpServletResponse.sendError(429,"Too many Requests");
        }
        return true;
    }

}
