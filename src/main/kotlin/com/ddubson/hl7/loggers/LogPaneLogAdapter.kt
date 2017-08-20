package com.ddubson.hl7.loggers

import com.ddubson.hl7.views.Loggable

class LogPaneLogAdapter(private val loggable: Loggable) : LogAdapter {
    override fun info(message: String) {
        loggable.log(message)
    }

    override fun info(message: String, color: ANSIColor) {
        loggable.log(message)
    }
}