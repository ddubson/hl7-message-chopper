package com.ddubson.hl7.messageProcessing

import com.ddubson.hl7.loggers.LogAdapter
import org.springframework.messaging.Message

class RawHL7SegmentPrinter(private val logAdapter: LogAdapter) {
    fun handle(message: Message<*>) {
        logAdapter.info("{${message.headers["messageId"].toString()}} ${message.payload}")
    }
}