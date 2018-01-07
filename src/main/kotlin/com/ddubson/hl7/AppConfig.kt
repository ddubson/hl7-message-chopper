package com.ddubson.hl7

import ca.uhn.hl7v2.DefaultHapiContext
import ca.uhn.hl7v2.HapiContext
import ca.uhn.hl7v2.parser.Parser
import com.ddubson.hl7.actions.LogMessageAction
import com.ddubson.hl7.fx.controllers.MessageDetailsPane
import com.ddubson.hl7.loggers.LogAdapter
import com.ddubson.hl7.loggers.LogPaneLogAdapter
import com.ddubson.hl7.messageProcessing.IDGenerator
import com.ddubson.hl7.messageProcessing.MessageReceiver
import com.ddubson.hl7.messageProcessing.RawHL7SegmentPrinter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun logAdapter(logMessageAction: LogMessageAction): LogAdapter = LogPaneLogAdapter(logMessageAction)

    @Bean
    fun hl7SegmentPrinter(logMessageAction: LogMessageAction): RawHL7SegmentPrinter = RawHL7SegmentPrinter(logAdapter(logMessageAction))

    @Bean
    fun messageReceiver(parser: Parser, messageDetailsPane: MessageDetailsPane) =
            MessageReceiver(parser, messageDetailsPane,
                    messageDetailsPane, messageDetailsPane)

    @Bean
    fun hapiContext(): HapiContext = DefaultHapiContext()

    @Bean
    fun hl7Parser(hapiContext: HapiContext): Parser = hapiContext.genericParser

    @Bean
    fun idGenerator(): IDGenerator {
        return IDGenerator()
    }
}