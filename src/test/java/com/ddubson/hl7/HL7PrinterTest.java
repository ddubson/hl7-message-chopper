package com.ddubson.hl7;

import com.ddubson.hl7.logging.ANSIColor;
import com.ddubson.hl7.logging.LogAdapter;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static com.ddubson.hl7.logging.ANSIColor.ANSI_WHITE;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HL7PrinterTest {
    @Test
    public void printMessage_shouldDisplayRawHL7Message() {
        LogAdapter logAdapter = mock(LogAdapter.class);
        ANSIColor color = ANSI_WHITE;
        HL7Printer viewer = new RawHL7Printer("prefix", color, logAdapter);

        Message<String> message = MessageBuilder.withPayload("A simple message").build();
        viewer.print(message);
        verify(logAdapter).info("prefix A simple message", color);
    }
}
