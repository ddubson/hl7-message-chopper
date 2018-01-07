package com.ddubson.hl7

import com.ddubson.hl7.fx.FXLoader
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ImportResource

@SpringBootApplication
@ImportResource("integration-context.xml")
class App : Application() {
    private lateinit var context: ConfigurableApplicationContext
    private lateinit var root: Parent

    override fun init() {
        context = SpringApplication.run(App::class.java)
        root = FXLoader().generateParent(context)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.title = "HL7 goodness"
        primaryStage.scene = Scene(root, 600.0, 600.0)
        primaryStage.show()
    }

    override fun stop() {
        context.stop()
        System.exit(0)
    }
}

fun main(args: Array<String>) {
    launch(App::class.java)
}