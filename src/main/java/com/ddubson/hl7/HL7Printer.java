package com.ddubson.hl7;

import org.springframework.messaging.Message;

public interface HL7Printer {
    void print(Message<?> message);
}
