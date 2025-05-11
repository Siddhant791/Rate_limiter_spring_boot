package com.example.practice.interceptor;

import com.example.practice.services.RateLimiterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor to handle rate limiting for incoming requests.
 */
public class RateLimiterInterceptor implements HandlerInterceptor {

    private final RateLimiterService rateLimiterService;

    /**
     * Constructor to inject the RateLimiterService dependency.
     *
     * @param rateLimiterService the service that provides rate limiting functionality
     */
    public RateLimiterInterceptor(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService; // Initialize the rate limiter service
    }

    /**
     * Pre-handle method to intercept requests and apply rate limiting.
     *
     * @param httpServletRequest  the incoming HTTP request
     * @param httpServletResponse the outgoing HTTP response
     * @param handler             the handler for the request
     * @return true if the request is allowed, false otherwise
     * @throws Exception if an error occurs during processing
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object handler) throws Exception {
        // Get the client ID from the request's remote address
        String clientId = httpServletRequest.getRemoteAddr();

        // Check if the request is allowed by the rate limiter
        if (!rateLimiterService.allowRequest(clientId)) {
            // If not allowed, send a 429 Too Many Requests error response
            httpServletResponse.sendError(429, "Too many Requests");
        }

        // Allow the request to proceed
        return true;
    }
}