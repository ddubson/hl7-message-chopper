package com.ddubson.hl7.enrichers

import java.util.*

class IDGenerator {
    fun generateId(): String {
        return UUID.randomUUID().toString()
    }
}