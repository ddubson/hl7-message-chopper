package com.ddubson.hl7.loggers

import com.ddubson.hl7.views.RootPaneController

class LogPaneLogAdapter(private val rootPaneController: RootPaneController) : LogAdapter {
    override fun info(message: String) {
        rootPaneController.logToScreen(message)
    }

    override fun info(message: String, color: ANSIColor) {
        rootPaneController.logToScreen(message)
    }
}