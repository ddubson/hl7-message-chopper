package com.ddubson.hl7.fx

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.util.Callback
import org.springframework.context.ConfigurableApplicationContext

class FXLoader {
    private val rootLayoutFxml = "/fxmls/RootLayout.fxml"

    fun generateParent(context: ConfigurableApplicationContext): Parent {
        val rootLoader = FXMLLoader(this.javaClass.getResource(rootLayoutFxml))
        rootLoader.controllerFactory = contextCallback(context)
        return rootLoader.load()
    }

    private fun contextCallback(context: ConfigurableApplicationContext): Callback<Class<*>, Any>? {
        return Callback { cls -> context.getBean(cls) }
    }
}