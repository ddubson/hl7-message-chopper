package com.ddubson.hl7.printers;

import com.ddubson.hl7.logging.ANSIColor;
import org.springframework.messaging.Message;

public interface HL7SegmentPrinter {
    void print(String type, Message<?> message, ANSIColor color);
}
