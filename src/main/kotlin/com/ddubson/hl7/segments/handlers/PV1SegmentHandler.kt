package com.ddubson.hl7.segments.handlers

import com.ddubson.hl7.loggers.ANSIColor
import com.ddubson.hl7.printers.HL7SegmentPrinter
import org.springframework.messaging.Message

class PV1SegmentHandler (val printer: HL7SegmentPrinter,
                         val color: ANSIColor) : HL7SegmentHandler {
    override fun handle(message: Message<*>) {
        printer.print("PV1", message, color)
    }
}