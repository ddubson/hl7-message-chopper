package com.ddubson.hl7;

import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public interface PayloadSplitter {
    List<String> split(Message<?> message);
}
