package com.ddubson.hl7.loggers

import com.ddubson.hl7.loggers.ANSIColor.ANSI_RESET

class CmdLineLogAdapter : LogAdapter {
    override fun info(message: String) {
        println(message)
    }

    override fun info(message: String, color: ANSIColor) {
        println("${color.color()} $message ${ANSI_RESET.color()}\n")
    }
}