package com.ddubson.hl7.splitters

import org.springframework.messaging.Message

interface PayloadSplitter {
    fun split(message: Message<Any>): List<String>
}