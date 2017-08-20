package com.ddubson.hl7

import com.ddubson.hl7.enrichers.IDGenerator
import com.ddubson.hl7.loggers.ANSIColor
import com.ddubson.hl7.loggers.LogAdapter
import com.ddubson.hl7.loggers.LogPaneLogAdapter
import com.ddubson.hl7.printers.HL7SegmentPrinter
import com.ddubson.hl7.printers.RawHL7SegmentPrinter
import com.ddubson.hl7.segments.handlers.*
import com.ddubson.hl7.splitters.NewlinePayloadSplitter
import com.ddubson.hl7.splitters.PayloadSplitter
import com.ddubson.hl7.views.LogPaneController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
    @Bean
    fun logAdapter(logPaneController: LogPaneController): LogAdapter {
        return LogPaneLogAdapter(logPaneController)
    }

    @Bean
    fun hl7SegmentPrinter(logPaneController: LogPaneController): HL7SegmentPrinter {
        return RawHL7SegmentPrinter(logAdapter(logPaneController))
    }

    @Bean("uncategorizedSegmentHandler")
    fun uncategorizedSegmentHandler(logPaneController: LogPaneController): HL7SegmentHandler {
        return UncategorizedSegmentHandler(hl7SegmentPrinter(logPaneController), ANSIColor.ANSI_WHITE)
    }

    @Bean("mshSegmentHandler")
    fun mshSegmentHandler(logPaneController: LogPaneController): HL7SegmentHandler {
        return MSHSegmentHandler(hl7SegmentPrinter(logPaneController), ANSIColor.ANSI_YELLOW)
    }

    @Bean("pidSegmentHandler")
    fun pidSegmentHandler(logPaneController: LogPaneController): HL7SegmentHandler {
        return PIDSegmentHandler(hl7SegmentPrinter(logPaneController), ANSIColor.ANSI_GREEN)
    }

    @Bean("pv1SegmentHandler")
    fun pv1SegmentHandler(logPaneController: LogPaneController): HL7SegmentHandler {
        return PV1SegmentHandler(hl7SegmentPrinter(logPaneController), ANSIColor.ANSI_CYAN)
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