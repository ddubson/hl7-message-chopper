package com.ddubson.hl7.logging;

public interface LogAdapter {
    void info(String message);

    void info(String message, ANSIColor color);
}
