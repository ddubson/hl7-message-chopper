package com.ddubson.hl7.fx.controllers;

import javafx.fxml.FXML
import javafx.scene.control.Label
import org.springframework.messaging.Message

public class MessageDetailsPane {
    fun updateDetails(message: Message<*>) {
        messageVersion!!.text = message.payload.toString().split("\n")[0].split("|")[11]
    }

    @FXML
    private var messageVersion: Label? = null
}
