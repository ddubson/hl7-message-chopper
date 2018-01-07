package com.ddubson.hl7.actions

import com.ddubson.hl7.messageProcessing.ProcessedMessage

interface MessageReceiveAction {
    fun onMessageReceive(message: ProcessedMessage)
}