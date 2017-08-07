package com.ddubson.hl7;

import com.ddubson.hl7.logging.CommandLineLogAdapter;
import com.ddubson.hl7.logging.LogAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import static com.ddubson.hl7.logging.ANSIColor.ANSI_WHITE;
import static com.ddubson.hl7.logging.ANSIColor.ANSI_YELLOW;

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

    @Bean("uncategorizedSegmentPrinter")
    public HL7Printer uncategorizedSegmentPrinter() {
        return new RawHL7Printer("[UNCATEGORIZED]", ANSI_WHITE, logAdapter());
    }

    @Bean("mshPrinter")
    public HL7Printer mshPrinter() {
        return new RawHL7Printer("[MSH]", ANSI_YELLOW, logAdapter());
    }

    @Bean("newlinePayloadSplitter")
    public PayloadSplitter newlinePayloadSplitter() {
        return new NewlinePayloadSplitter();
    }
}
