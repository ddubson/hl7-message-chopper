package com.ddubson.hl7.segments.handlers;

import com.ddubson.hl7.printers.HL7SegmentPrinter;
import com.ddubson.hl7.logging.ANSIColor;
import org.springframework.messaging.Message;

public class PIDSegmentSegmentHandler implements HL7SegmentHandler {
    private ANSIColor color;
    private HL7SegmentPrinter segmentPrinter;

    public PIDSegmentSegmentHandler(HL7SegmentPrinter segmentPrinter, ANSIColor color) {
        this.segmentPrinter = segmentPrinter;
        this.color = color;
    }

    @Override
    public void handle(Message<?> message) {
        segmentPrinter.print("PID", message, color);
    }
}
