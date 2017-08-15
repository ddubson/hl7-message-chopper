package com.ddubson.hl7.segments.handlers

import com.ddubson.hl7.loggers.ANSIColor
import com.ddubson.hl7.printers.HL7SegmentPrinter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder

@RunWith(JUnitPlatform::class)
class UncategorizedSegmentHandlerTest : Spek({
    val hl7printer = mock<HL7SegmentPrinter> {}
    val color = ANSIColor.ANSI_WHITE
    val segmentHandler = UncategorizedSegmentHandler(hl7printer, color)

    given("an uncategorized HL7 segment") {
        val uncategorizedSegment = "UNC|HELLO WORLD!"
        val message: Message<String> = MessageBuilder.withPayload(uncategorizedSegment).build()

        on("handle") {
            segmentHandler.handle(message)

            it("should have called the hl7 printer") {
                verify(hl7printer).print("Uncategorized", message, color)
            }
        }
    }
})