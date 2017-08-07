package com.ddubson.hl7.splitters;

import org.springframework.messaging.Message;

import java.util.List;

import static java.util.Arrays.asList;

public class NewlinePayloadSplitter implements PayloadSplitter {
    @Override
    public List<String> split(Message<?> message) {
        return asList(message.getPayload().toString().split("\n"));
    }
}