package com.ddubson.hl7;

import com.ddubson.hl7.logging.ANSIColor;
import com.ddubson.hl7.logging.LogAdapter;
import com.ddubson.hl7.segments.handlers.HL7SegmentHandler;
import com.ddubson.hl7.segments.handlers.UncategorizedSegmentSegmentHandler;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static com.ddubson.hl7.logging.ANSIColor.ANSI_WHITE;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HL7SegmentHandlerTest {
    @Test
    public void printMessage_shouldDisplayRawHL7Message() {
        LogAdapter logAdapter = mock(LogAdapter.class);
        ANSIColor color = ANSI_WHITE;
        HL7SegmentHandler viewer = new UncategorizedSegmentSegmentHandler(logAdapter, color);

        Message<String> message = MessageBuilder.withPayload("A simple message").build();
        viewer.handle(message);
        verify(logAdapter).info("[Uncategorized Segment] A simple message", color);
    }
}
