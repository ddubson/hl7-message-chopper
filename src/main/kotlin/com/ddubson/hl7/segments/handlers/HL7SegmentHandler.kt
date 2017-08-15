package com.ddubson.hl7.segments.handlers

import org.springframework.messaging.Message

interface HL7SegmentHandler {
    fun handle(message: Message<*>)
}