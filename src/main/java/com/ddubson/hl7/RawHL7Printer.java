package com.ddubson.hl7;

import com.ddubson.hl7.logging.ANSIColor;
import com.ddubson.hl7.logging.LogAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import static com.ddubson.hl7.logging.ANSIColor.ANSI_YELLOW;
import static java.lang.String.format;

public class RawHL7Printer implements HL7Printer {
    private final ANSIColor color;
    private final LogAdapter logAdapter;
    private final String prefix;

    @Autowired
    public RawHL7Printer(String prefix, ANSIColor color, LogAdapter logAdapter) {
        this.color = color;
        this.logAdapter = logAdapter;
        this.prefix = prefix;
    }

    @Override
    public void print(Message<?> message) {
        logAdapter.info(format("%s %s", prefix, message.getPayload().toString()), color);
    }
}
