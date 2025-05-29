package com.example.practice.components;

import org.springframework.stereotype.Component;

@Component
@org.springframework.web.context.annotation.RequestScope
public class RequestScope {

    private String requestId;

    public RequestScope() {
        // Initialize with a unique request ID, for example using UUID
        this.requestId = java.util.UUID.randomUUID().toString();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
