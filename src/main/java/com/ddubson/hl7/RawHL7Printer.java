package com.ddubson.hl7;

import com.ddubson.hl7.logging.LogAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import static com.ddubson.hl7.logging.ANSIColor.ANSI_YELLOW;

public class RawHL7Printer implements HL7Printer {
    private final LogAdapter logAdapter;

    @Autowired
    public RawHL7Printer(LogAdapter logAdapter) {
        this.logAdapter = logAdapter;
    }

    @Override
    public void print(Message<?> message) {
        logAdapter.info(message.getPayload().toString(), ANSI_YELLOW);
    }
}
