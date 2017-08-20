package com.ddubson.hl7.printers

import com.ddubson.hl7.loggers.ANSIColor
import com.ddubson.hl7.loggers.LogAdapter
import org.springframework.messaging.Message

class RawHL7SegmentPrinter(val logAdapter: LogAdapter) : HL7SegmentPrinter{
    override fun print(type: String, message: Message<*>, color: ANSIColor) {
        logAdapter.info("{${message.headers["messageId"].toString()}} [$type Segment] ${message.payload}",
                color)
    }
}