package com.ddubson.hl7

import com.ddubson.hl7.fx.controllers.MessageDetailsPane
import com.ddubson.hl7.fx.controllers.RootPaneController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UIConfig {
    @Bean
    fun rootPaneController(): RootPaneController = RootPaneController()

    @Bean
    fun messageDetailsPane(): MessageDetailsPane = MessageDetailsPane()
}