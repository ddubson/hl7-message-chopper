package com.ddubson.hl7.files

import com.ddubson.hl7.views.RootPaneController
import org.springframework.messaging.Message

class HL7FileCounter(private val rootPaneController: RootPaneController) {
    private var counter = 0

    fun count(msg: Message<*>) {
        rootPaneController.incFilesRead(++counter)
    }
}