package com.ddubson.hl7.printers;

import com.ddubson.hl7.logging.ANSIColor;
import com.ddubson.hl7.logging.LogAdapter;
import org.springframework.messaging.Message;

import static java.lang.String.format;

public class RawHL7SegmentPrinter implements HL7SegmentPrinter {
    private LogAdapter logAdapter;

    public RawHL7SegmentPrinter(LogAdapter logAdapter) {
        this.logAdapter = logAdapter;
    }

    @Override
    public void print(String type, Message<?> message, ANSIColor color) {
        String messageId = "{" + message.getHeaders().get("messageId").toString() + "}";
        String banner = "["+type+" Segment]";
        logAdapter.info(format("%s %s %s", messageId,
                banner, message.getPayload().toString()), color);
    }
}
