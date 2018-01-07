package com.ddubson.hl7.messageProcessing

import java.util.*

class IDGenerator {
    fun generateId(): String {
        return UUID.randomUUID().toString()
    }
}