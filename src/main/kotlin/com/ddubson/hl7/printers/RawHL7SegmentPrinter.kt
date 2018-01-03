package com.ddubson.hl7.printers

import com.ddubson.hl7.loggers.LogAdapter
import org.springframework.messaging.Message

class RawHL7SegmentPrinter(val logAdapter: LogAdapter){
    fun handle(message: Message<*>) {
        logAdapter.info("{${message.headers["messageId"].toString()}} ${message.payload}")
    }
}