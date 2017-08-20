package com.ddubson.hl7

import javafx.application.Application
import javafx.application.Application.launch
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import javafx.stage.WindowEvent
import javafx.util.Callback
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ImportResource
import org.springframework.integration.endpoint.SourcePollingChannelAdapter

@SpringBootApplication
@ImportResource("integration-context.xml")
class App : Application() {
    private lateinit var context: ConfigurableApplicationContext
    private lateinit var root: BorderPane

    override fun init() {
        context = SpringApplication.run(App::class.java)
        val rootLoader = FXMLLoader(this.javaClass.getResource("/fxmls/RootLayout.fxml"))
        rootLoader.controllerFactory = contextCallback()
        root = rootLoader.load()
    }

    override fun stop() {
        context.stop()
        System.exit(0)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.title = "HL7 goodness"
        primaryStage.scene = Scene(root, 600.0, 600.0)

        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWING, { _ ->
            val inf = context.getBean("inboundFileChannelAdapter") as SourcePollingChannelAdapter
            inf.start()
        })

        primaryStage.show()
    }

    fun contextCallback(): Callback<Class<*>, Any>? {
        return Callback { cls -> context.getBean(cls) }
    }
}

fun main(args: Array<String>) {
    launch(App::class.java)
}