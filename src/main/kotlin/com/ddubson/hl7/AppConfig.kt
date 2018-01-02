package com.ddubson.hl7

import com.ddubson.hl7.enrichers.IDGenerator
import com.ddubson.hl7.loggers.LogAdapter
import com.ddubson.hl7.loggers.LogPaneLogAdapter
import com.ddubson.hl7.printers.HL7SegmentPrinter
import com.ddubson.hl7.printers.RawHL7SegmentPrinter
import com.ddubson.hl7.splitters.NewlinePayloadSplitter
import com.ddubson.hl7.splitters.PayloadSplitter
import com.ddubson.hl7.views.Loggable
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun logAdapter(loggable:Loggable): LogAdapter {
        return LogPaneLogAdapter(loggable)
    }

    @Bean
    fun hl7SegmentPrinter(loggable: Loggable): HL7SegmentPrinter {
        return RawHL7SegmentPrinter(logAdapter(loggable))
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