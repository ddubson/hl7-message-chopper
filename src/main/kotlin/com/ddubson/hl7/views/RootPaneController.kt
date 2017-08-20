package com.ddubson.hl7.views

import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.text.Text
import org.springframework.stereotype.Component

@Component
class RootPaneController {
    @FXML
    private var logField: TextArea? = null

    @FXML
    private var filesReadText: Text? = null

    fun logToScreen(message: String) {
        logField!!.text = "${logField!!.text}\n$message"
    }

    fun incFilesRead(count: Int) {
        filesReadText!!.text = count.toString()
    }
}