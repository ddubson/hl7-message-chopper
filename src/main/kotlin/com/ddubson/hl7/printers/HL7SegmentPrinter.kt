package com.ddubson.hl7.printers

import com.ddubson.hl7.loggers.ANSIColor
import org.springframework.messaging.Message

interface HL7SegmentPrinter {
    fun print(type: String, message: Message<*>, color: ANSIColor)
}