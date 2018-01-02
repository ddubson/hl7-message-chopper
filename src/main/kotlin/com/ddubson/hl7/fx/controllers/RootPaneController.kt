package com.ddubson.hl7.fx.controllers

import com.ddubson.hl7.views.Loggable
import javafx.application.Platform
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import java.net.URL
import java.util.*

class RootPaneController : Initializable, Loggable {
    private var list : ObservableList<String>? = null

    @FXML
    private var logField: TextArea? = null

    @FXML
    private var messageVersion: Label? = null

    override fun log(message: String) {
        logField!!.text = "${logField!!.text}\n$message"
    }

    fun addFileNameToFileList(fileName: String) {
        Platform.runLater({ list!!.add(fileName)})
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }
}