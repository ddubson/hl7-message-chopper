package com.ddubson.hl7.segments.handlers;

import com.ddubson.hl7.printers.HL7SegmentPrinter;
import com.ddubson.hl7.logging.ANSIColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

public class UncategorizedSegmentSegmentHandler implements HL7SegmentHandler {
    private final ANSIColor color;
    private final HL7SegmentPrinter segmentPrinter;

    @Autowired
    public UncategorizedSegmentSegmentHandler(HL7SegmentPrinter segmentPrinter, ANSIColor color) {
        this.segmentPrinter = segmentPrinter;
        this.color = color;
    }

    @Override
    public void handle(Message<?> message) {
        segmentPrinter.print("Uncategorized", message, color);    }
}
