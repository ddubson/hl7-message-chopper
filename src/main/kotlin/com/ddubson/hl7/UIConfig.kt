package com.ddubson.hl7

import com.ddubson.hl7.fx.controllers.MessageDetailsPane
import com.ddubson.hl7.fx.controllers.RootPaneController
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.channel.PublishSubscribeChannel

@Configuration
class UIConfig {
    @Bean
    fun rootPaneController(@Qualifier("idChannel") idChannel: PublishSubscribeChannel): RootPaneController =
            RootPaneController(idChannel)

    @Bean
    fun messageDetailsPane(): MessageDetailsPane = MessageDetailsPane()
}