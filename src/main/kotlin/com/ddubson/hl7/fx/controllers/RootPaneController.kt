package com.ddubson.hl7.fx.controllers

import com.ddubson.hl7.actions.LogMessageAction
import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.stage.FileChooser
import org.springframework.integration.channel.PublishSubscribeChannel
import org.springframework.messaging.support.MessageBuilder

class RootPaneController(private val idChannel: PublishSubscribeChannel) : LogMessageAction {
    @FXML
    private var logField: TextArea? = null

    @FXML
    fun openFile() {
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(null)

        if (selectedFile != null) {
            idChannel.send(MessageBuilder.withPayload(selectedFile).build())
        }
    }

    override fun log(message: String) {
        logField!!.text = "${logField!!.text}\n$message"
    }
}