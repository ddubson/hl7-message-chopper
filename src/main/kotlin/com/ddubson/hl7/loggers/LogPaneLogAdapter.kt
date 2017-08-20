package com.ddubson.hl7.loggers

import com.ddubson.hl7.views.LogPaneController

class LogPaneLogAdapter(private val logPaneController: LogPaneController) : LogAdapter {
    override fun info(message: String) {
        logPaneController.logToScreen(message)
    }

    override fun info(message: String, color: ANSIColor) {
        println(message)
        logPaneController.logToScreen(message)
    }
}