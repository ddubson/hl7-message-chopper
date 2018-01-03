package com.ddubson.hl7.fx.controllers

import com.ddubson.hl7.views.Loggable
import javafx.fxml.FXML
import javafx.scene.control.TextArea

class RootPaneController : Loggable {
    @FXML
    private var logField: TextArea? = null

    override fun log(message: String) {
        logField!!.text = "${logField!!.text}\n$message"
    }
}