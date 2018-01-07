package com.ddubson.hl7.fx.controllers

import com.ddubson.hl7.actions.LogMessageAction
import javafx.fxml.FXML
import javafx.scene.control.TextArea

class RootPaneController : LogMessageAction {
    @FXML
    private var logField: TextArea? = null

    override fun log(message: String) {
        logField!!.text = "${logField!!.text}\n$message"
    }
}