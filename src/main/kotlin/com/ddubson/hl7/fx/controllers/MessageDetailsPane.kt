package com.ddubson.hl7.fx.controllers;

import ca.uhn.hl7v2.model.v23.message.ADT_A01
import ca.uhn.hl7v2.parser.Parser
import javafx.fxml.FXML
import javafx.scene.control.Label
import org.springframework.messaging.Message

class MessageDetailsPane(private val hl7parser: Parser) {
    @FXML
    private var messageVersion: Label? = null

    @FXML
    private var messageType: Label? = null

    fun updateDetails(message: Message<*>) {
        val hl7msg = hl7parser.parse(message.payload.toString())
        messageVersion!!.text = hl7msg.version
        messageType!!.text = (hl7msg as ADT_A01).msh.messageType.messageType.value
    }
}
