package com.ddubson.hl7.segments.handlers;

import org.springframework.messaging.Message;

public interface HL7SegmentHandler {
    void handle(Message<?> message);
}
