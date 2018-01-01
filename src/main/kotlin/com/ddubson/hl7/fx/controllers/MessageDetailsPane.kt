package com.ddubson.hl7.fx.controllers;

import com.ddubson.hl7.segments.handlers.HL7SegmentHandler
import javafx.fxml.FXML
import javafx.scene.control.Label
import org.springframework.messaging.Message

public class MessageDetailsPane:HL7SegmentHandler {
    override fun handle(message: Message<*>) {
        messageVersion!!.text = message.payload.toString()
    }

    @FXML
    private var messageVersion: Label? = null
}
