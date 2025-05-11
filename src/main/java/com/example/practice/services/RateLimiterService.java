package com.example.practice.services;

import com.example.practice.components.TokensBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {

    private ConcurrentHashMap<String,TokensBucket> requestsMap = new ConcurrentHashMap<>();
    private final int CAPACITY = 5;
    private final int REFILL_RATE = 1;

    public boolean allowRequest(String clientId){
        TokensBucket tokenBucket = requestsMap.computeIfAbsent(clientId , i -> new TokensBucket(CAPACITY,REFILL_RATE));
        return tokenBucket.tryConsume();
    }
}
