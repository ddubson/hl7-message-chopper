package com.ddubson.hl7.loggers

interface LogAdapter {
    fun info(message: String)

    fun info(message: String, color: ANSIColor)
}