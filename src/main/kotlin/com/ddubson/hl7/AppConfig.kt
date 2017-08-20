package com.ddubson.hl7

import com.ddubson.hl7.enrichers.IDGenerator
import com.ddubson.hl7.files.HL7FileCounter
import com.ddubson.hl7.loggers.ANSIColor
import com.ddubson.hl7.loggers.LogAdapter
import com.ddubson.hl7.loggers.LogPaneLogAdapter
import com.ddubson.hl7.printers.HL7SegmentPrinter
import com.ddubson.hl7.printers.RawHL7SegmentPrinter
import com.ddubson.hl7.segments.handlers.*
import com.ddubson.hl7.splitters.NewlinePayloadSplitter
import com.ddubson.hl7.splitters.PayloadSplitter
import com.ddubson.hl7.views.Loggable
import com.ddubson.hl7.fx.controllers.RootPaneController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun fileCounter(rootPaneController: RootPaneController): HL7FileCounter {
        return HL7FileCounter(rootPaneController)
    }

    @Bean
    fun logAdapter(loggable:Loggable): LogAdapter {
        return LogPaneLogAdapter(loggable)
    }

    @Bean
    fun hl7SegmentPrinter(loggable: Loggable): HL7SegmentPrinter {
        return RawHL7SegmentPrinter(logAdapter(loggable))
    }

    @Bean("uncategorizedSegmentHandler")
    fun uncategorizedSegmentHandler(loggable: Loggable): HL7SegmentHandler {
        return UncategorizedSegmentHandler(hl7SegmentPrinter(loggable), ANSIColor.ANSI_WHITE)
    }

    @Bean("mshSegmentHandler")
    fun mshSegmentHandler(loggable: Loggable): HL7SegmentHandler {
        return MSHSegmentHandler(hl7SegmentPrinter(loggable), ANSIColor.ANSI_YELLOW)
    }

    @Bean("pidSegmentHandler")
    fun pidSegmentHandler(loggable: Loggable): HL7SegmentHandler {
        return PIDSegmentHandler(hl7SegmentPrinter(loggable), ANSIColor.ANSI_GREEN)
    }

    @Bean("pv1SegmentHandler")
    fun pv1SegmentHandler(loggable: Loggable): HL7SegmentHandler {
        return PV1SegmentHandler(hl7SegmentPrinter(loggable), ANSIColor.ANSI_CYAN)
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