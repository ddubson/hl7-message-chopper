package com.ddubson.hl7.splitters

import org.springframework.messaging.Message

class NewlinePayloadSplitter : PayloadSplitter {
    override fun split(message: Message<Any>): List<String> {
        return message.payload.toString().split("\n")
    }
}