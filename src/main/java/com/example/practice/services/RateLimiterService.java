package com.example.practice.services;

import com.example.practice.components.TokensBucket;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service // Marks this class as a Spring-managed service
public class RateLimiterService {

    // Map to store token buckets for each client, identified by their client ID
    private ConcurrentHashMap<String, TokensBucket> requestsMap = new ConcurrentHashMap<>();

    // Maximum number of tokens allowed in a bucket
    private final int CAPACITY = 5;

    // Rate at which tokens are refilled in the bucket (tokens per second)
    private final int REFILL_RATE = 1;

    /**
     * Checks if a request from a client is allowed based on rate limiting.
     *
     * @param clientId the unique identifier for the client (e.g., IP address)
     * @return true if the request is allowed, false otherwise
     */
    public boolean allowRequest(String clientId) {
        // Retrieve or create a token bucket for the client
        TokensBucket tokenBucket = requestsMap.computeIfAbsent(clientId,
                i -> new TokensBucket(CAPACITY, REFILL_RATE));

        // Attempt to consume a token from the bucket
        return tokenBucket.tryConsume();
    }
}