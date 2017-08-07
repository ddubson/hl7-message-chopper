package com.ddubson.hl7;

import com.ddubson.hl7.logging.CommandLineLogAdapter;
import com.ddubson.hl7.logging.LogAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

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

    @Bean("rawHL7Printer")
    public HL7Printer hl7Printer() {
        return new RawHL7Printer(logAdapter());
    }
}
