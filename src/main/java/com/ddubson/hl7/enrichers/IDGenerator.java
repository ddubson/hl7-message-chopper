package com.ddubson.hl7.enrichers;

import org.springframework.messaging.Message;

import java.util.UUID;

public class IDGenerator {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
