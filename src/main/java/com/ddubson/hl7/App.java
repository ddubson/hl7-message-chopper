package com.ddubson.hl7;

import com.ddubson.hl7.enrichers.IDGenerator;
import com.ddubson.hl7.logging.CommandLineLogAdapter;
import com.ddubson.hl7.logging.LogAdapter;
import com.ddubson.hl7.printers.HL7SegmentPrinter;
import com.ddubson.hl7.printers.RawHL7SegmentPrinter;
import com.ddubson.hl7.segments.handlers.*;
import com.ddubson.hl7.splitters.NewlinePayloadSplitter;
import com.ddubson.hl7.splitters.PayloadSplitter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import static com.ddubson.hl7.logging.ANSIColor.*;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public LogAdapter logAdapter() {
        return new CommandLineLogAdapter();
    }

    @Bean
    public HL7SegmentPrinter hl7SegmentPrinter() {
        return new RawHL7SegmentPrinter(logAdapter());
    }

    @Bean("uncategorizedSegmentHandler")
    public HL7SegmentHandler uncategorizedSegmentHandler() {
        return new UncategorizedSegmentSegmentHandler(hl7SegmentPrinter(), ANSI_WHITE);
    }

    @Bean("mshSegmentHandler")
    public HL7SegmentHandler mshSegmentHandler() {
        return new MSHSegmentHandler(hl7SegmentPrinter(), ANSI_YELLOW);
    }

    @Bean("pidSegmentHandler")
    public HL7SegmentHandler pidSegmentHandler() {
        return new PIDSegmentSegmentHandler(hl7SegmentPrinter(), ANSI_GREEN);
    }

    @Bean("pv1SegmentHandler")
    public HL7SegmentHandler pv1SegmentHandler() {
        return new PV1SegmentHandler(hl7SegmentPrinter(), ANSI_CYAN);
    }

    @Bean("newlinePayloadSplitter")
    public PayloadSplitter newlinePayloadSplitter() {
        return new NewlinePayloadSplitter();
    }

    @Bean
    public IDGenerator idGenerator() {
        return new IDGenerator();
    }
}
