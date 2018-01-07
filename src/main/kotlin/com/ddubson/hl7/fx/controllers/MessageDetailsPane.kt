package com.ddubson.hl7.fx.controllers;

import com.ddubson.hl7.actions.MessageReceiveAction
import com.ddubson.hl7.actions.MessageTypeReceiveAction
import com.ddubson.hl7.actions.MessageVersionReceiveAction
import com.ddubson.hl7.messageProcessing.ProcessedMessage
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField

class MessageDetailsPane : MessageVersionReceiveAction,
        MessageTypeReceiveAction, MessageReceiveAction {
    @FXML
    private var messageVersion: Label? = null

    @FXML
    private var messageType: Label? = null

    @FXML
    private var patientName: TextField? = null

    @FXML
    private var patientSex: TextField? = null

    @FXML
    private var patientRace: TextField? = null

    override fun onMessageReceive(message: ProcessedMessage) {
        this.patientName!!.text = "${message.lastName}, ${message.firstName}"
        this.patientSex!!.text = message.sex.sex
        this.patientRace!!.text = message.race
    }

    override fun onMessageTypeReceive(messageType: String) {
        this.messageType!!.text = messageType
    }

    override fun onMessageVersionReceive(messageVersion: String) {
        this.messageVersion!!.text = messageVersion
    }
}
