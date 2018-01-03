package com.ddubson.hl7

import ca.uhn.hl7v2.DefaultHapiContext
import ca.uhn.hl7v2.HapiContext
import ca.uhn.hl7v2.parser.Parser
import com.ddubson.hl7.enrichers.IDGenerator
import com.ddubson.hl7.loggers.LogAdapter
import com.ddubson.hl7.loggers.LogPaneLogAdapter
import com.ddubson.hl7.printers.RawHL7SegmentPrinter
import com.ddubson.hl7.splitters.NewlinePayloadSplitter
import com.ddubson.hl7.splitters.PayloadSplitter
import com.ddubson.hl7.views.Loggable
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun logAdapter(loggable: Loggable): LogAdapter = LogPaneLogAdapter(loggable)

    @Bean
    fun hl7SegmentPrinter(loggable: Loggable): RawHL7SegmentPrinter = RawHL7SegmentPrinter(logAdapter(loggable))

    @Bean
    fun hapiContext(): HapiContext = DefaultHapiContext()

    @Bean
    fun hl7Parser(hapiContext: HapiContext): Parser = hapiContext.genericParser

    @Bean("newlinePayloadSplitter")
    fun newlinePayloadSplitter(): PayloadSplitter {
        return NewlinePayloadSplitter()
    }

    @Bean
    fun idGenerator(): IDGenerator {
        return IDGenerator()
    }
}