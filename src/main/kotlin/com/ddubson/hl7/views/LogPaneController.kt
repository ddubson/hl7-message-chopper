package com.ddubson.hl7.views

import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.layout.Pane
import org.springframework.stereotype.Component

@Component
class LogPaneController {
    @FXML
    private var logPane: Pane? = null

    @FXML
    private var logField: TextArea? = null

    fun logToScreen(message: String) {
        logField!!.text = "${logField!!.text}\n$message"
    }
}