package com.ddubson.hl7.actions

interface MessageVersionReceiveAction {
    fun onMessageVersionReceive(messageVersion: String)
}