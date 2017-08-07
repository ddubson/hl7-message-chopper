package com.ddubson.hl7.segments.handlers;

import com.ddubson.hl7.logging.ANSIColor;
import com.ddubson.hl7.printers.HL7SegmentPrinter;
import org.springframework.messaging.Message;

public class PV1SegmentHandler implements HL7SegmentHandler {
    private ANSIColor color;
    private final HL7SegmentPrinter segmentPrinter;

    public PV1SegmentHandler(HL7SegmentPrinter segmentHandler, ANSIColor color) {
        this.color = color;
        this.segmentPrinter = segmentHandler;
    }

    @Override
    public void handle(Message<?> message) {
        segmentPrinter.print("PV1", message, color);
    }
}
