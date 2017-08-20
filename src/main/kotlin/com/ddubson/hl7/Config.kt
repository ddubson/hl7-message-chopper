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
import com.ddubson.hl7.views.RootPaneController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
    @Bean
    fun fileCounter(rootPaneController: RootPaneController): HL7FileCounter {
        return HL7FileCounter(rootPaneController)
    }

    @Bean
    fun logAdapter(rootPaneController: RootPaneController): LogAdapter {
        return LogPaneLogAdapter(rootPaneController)
    }

    @Bean
    fun hl7SegmentPrinter(rootPaneController: RootPaneController): HL7SegmentPrinter {
        return RawHL7SegmentPrinter(logAdapter(rootPaneController))
    }

    @Bean("uncategorizedSegmentHandler")
    fun uncategorizedSegmentHandler(rootPaneController: RootPaneController): HL7SegmentHandler {
        return UncategorizedSegmentHandler(hl7SegmentPrinter(rootPaneController), ANSIColor.ANSI_WHITE)
    }

    @Bean("mshSegmentHandler")
    fun mshSegmentHandler(rootPaneController: RootPaneController): HL7SegmentHandler {
        return MSHSegmentHandler(hl7SegmentPrinter(rootPaneController), ANSIColor.ANSI_YELLOW)
    }

    @Bean("pidSegmentHandler")
    fun pidSegmentHandler(rootPaneController: RootPaneController): HL7SegmentHandler {
        return PIDSegmentHandler(hl7SegmentPrinter(rootPaneController), ANSIColor.ANSI_GREEN)
    }

    @Bean("pv1SegmentHandler")
    fun pv1SegmentHandler(rootPaneController: RootPaneController): HL7SegmentHandler {
        return PV1SegmentHandler(hl7SegmentPrinter(rootPaneController), ANSIColor.ANSI_CYAN)
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