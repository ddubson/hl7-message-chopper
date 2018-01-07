package com.ddubson.hl7.loggers

import com.ddubson.hl7.actions.LogMessageAction

class LogPaneLogAdapter(private val logMessageAction: LogMessageAction) : LogAdapter {
    override fun info(message: String) {
        logMessageAction.log(message)
    }

    override fun info(message: String, color: ANSIColor) {
        logMessageAction.log(message)
    }
}