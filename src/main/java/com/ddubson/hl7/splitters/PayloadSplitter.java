package com.ddubson.hl7.splitters;

import org.springframework.messaging.Message;

import java.util.List;

public interface PayloadSplitter {
    List<String> split(Message<?> message);
}
