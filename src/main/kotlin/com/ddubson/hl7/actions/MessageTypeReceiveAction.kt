package com.ddubson.hl7.actions

interface MessageTypeReceiveAction {
    fun onMessageTypeReceive(messageType: String)
}