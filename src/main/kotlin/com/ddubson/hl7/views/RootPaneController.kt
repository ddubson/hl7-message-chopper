package com.ddubson.hl7.views

import javafx.application.Platform
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ListView
import javafx.scene.control.TextArea
import javafx.scene.text.Text
import org.springframework.stereotype.Component
import java.net.URL
import java.util.*

@Component
class RootPaneController : Initializable {
    private var list : ObservableList<String>? = null

    @FXML
    private var logField: TextArea? = null

    @FXML
    private var filesReadText: Text? = null

    @FXML
    private var fileList: ListView<String>? = null

    fun logToScreen(message: String) {
        logField!!.text = "${logField!!.text}\n$message"
    }

    fun incFilesRead(count: Int) {
        filesReadText!!.text = count.toString()
    }

    fun addFileNameToFileList(fileName: String) {
        Platform.runLater({ -> list!!.add(fileName)})
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        list = fileList!!.items
    }
}