package com.ddubson.hl7

import ca.uhn.hl7v2.parser.Parser
import com.ddubson.hl7.fx.controllers.MessageDetailsPane
import com.ddubson.hl7.fx.controllers.RootPaneController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UIConfig {
    @Bean
    fun rootPaneController(): RootPaneController = RootPaneController()

    @Bean
    fun messageDetailsPane(hl7Parser: Parser): MessageDetailsPane = MessageDetailsPane(hl7Parser)
}