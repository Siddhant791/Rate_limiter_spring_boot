package com.example.practice.components;

import java.time.Duration;
import java.time.Instant;

/**
 * {@code TokensBucket} class implements a token bucket algorithm for rate limiting.
 * It manages the number of tokens available for a client, refilling them at a specified rate.
 */
public class TokensBucket {
    private int capacity; // Maximum number of tokens the bucket can hold
    private Instant lastRefillTime; // Timestamp of the last refill
    private double tokens; // Current number of tokens in the bucket
    private final double refillRate; // Rate at which tokens are refilled (tokens per second)

    /**
     * Constructs a {@code TokensBucket} with the specified capacity and refill rate.
     *
     * @param capacity   the maximum number of tokens the bucket can hold.
     * @param refillRate the rate at which tokens are refilled, in tokens per second.
     */
    public TokensBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.lastRefillTime = Instant.now(); // Initialize the last refill time to the current time
        this.tokens = capacity; // Initialize the bucket with full capacity
    }

    /**
     * Attempts to consume a token from the bucket.
     * If a token is available, it consumes the token and returns true.
     * If no tokens are available, it returns false.
     * This method is synchronized to ensure thread safety.
     *
     * @return {@code true} if a token was successfully consumed, {@code false} otherwise.
     */
    public synchronized boolean tryConsume() {
        refill(); // Refill tokens before attempting to consume
        if (tokens >= 1) { // Check if at least one token is available
            tokens--; // Consume one token
            return true; // Indicate successful consumption
        }
        return false; // Indicate failure to consume a token
    }

    /**
     * Refills the tokens in the bucket based on the elapsed time since the last refill.
     * The number of tokens added is determined by the refill rate and the elapsed time.
     * The tokens are capped at the maximum capacity of the bucket.
     */
    private void refill() {
        Instant now = Instant.now(); // Get the current time
        long elapsedTime = Duration.between(lastRefillTime, now).toNanos(); // Calculate elapsed time in nanoseconds
        double elapsedTimeInSeconds = elapsedTime / 1_000_000_000.0; // Convert elapsed time to seconds

        double newTokens = elapsedTimeInSeconds * refillRate; // Calculate the number of tokens to add
        tokens = Math.min(capacity, tokens + newTokens); // Add tokens, ensuring the total does not exceed capacity
        lastRefillTime = now; // Update the last refill time to the current time
    }
}