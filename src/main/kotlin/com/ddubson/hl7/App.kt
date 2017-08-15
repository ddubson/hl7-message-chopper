package com.ddubson.hl7

import com.ddubson.hl7.enrichers.IDGenerator
import com.ddubson.hl7.loggers.ANSIColor
import com.ddubson.hl7.loggers.ANSIColor.ANSI_CYAN
import com.ddubson.hl7.loggers.CmdLineLogAdapter
import com.ddubson.hl7.loggers.LogAdapter
import com.ddubson.hl7.printers.HL7SegmentPrinter
import com.ddubson.hl7.printers.RawHL7SegmentPrinter
import com.ddubson.hl7.segments.handlers.*
import com.ddubson.hl7.splitters.NewlinePayloadSplitter
import com.ddubson.hl7.splitters.PayloadSplitter
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ImportResource

@SpringBootApplication
@ImportResource("integration-context.xml")
class App : Application(), CommandLineRunner {
    private lateinit var primaryStage: Stage

    override fun start(primaryStage: Stage) {
        val rootLoader = FXMLLoader(this.javaClass.getResource("/MenuLayout.fxml"))
        val logPaneLoader = FXMLLoader(this.javaClass.getResource("/LogPane.fxml"))

        val primaryPane: BorderPane = rootLoader.load()
        primaryPane.bottom = logPaneLoader.load()

        this.primaryStage = primaryStage
        this.primaryStage.title = "HL7 goodness"
        this.primaryStage.scene = Scene(primaryPane)
        primaryStage.show()
    }

    override fun run(vararg args: String?) {
        launch(*args)
    }

    @Bean
    fun logAdapter(): LogAdapter {
        return CmdLineLogAdapter()
    }

    @Bean
    fun hl7SegmentPrinter(): HL7SegmentPrinter {
        return RawHL7SegmentPrinter(logAdapter())
    }

    @Bean("uncategorizedSegmentHandler")
    fun uncategorizedSegmentHandler(): HL7SegmentHandler {
        return UncategorizedSegmentHandler(hl7SegmentPrinter(), ANSIColor.ANSI_WHITE)
    }

    @Bean("mshSegmentHandler")
    fun mshSegmentHandler(): HL7SegmentHandler {
        return MSHSegmentHandler(hl7SegmentPrinter(), ANSIColor.ANSI_YELLOW)
    }

    @Bean("pidSegmentHandler")
    fun pidSegmentHandler(): HL7SegmentHandler {
        return PIDSegmentHandler(hl7SegmentPrinter(), ANSIColor.ANSI_GREEN)
    }

    @Bean("pv1SegmentHandler")
    fun pv1SegmentHandler(): HL7SegmentHandler {
        return PV1SegmentHandler(hl7SegmentPrinter(), ANSI_CYAN)
    }

    @Bean("newlinePayloadSplitter")
    fun newlinePayloadSplitter(): PayloadSplitter {
        return NewlinePayloadSplitter()
    }

    @Bean
    fun idGenerator(): IDGenerator {
        return IDGenerator()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}