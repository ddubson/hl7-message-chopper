package com.ddubson.hl7.messageProcessing

import ca.uhn.hl7v2.model.v23.message.ADT_A01
import ca.uhn.hl7v2.parser.Parser
import com.ddubson.hl7.actions.MessageReceiveAction
import com.ddubson.hl7.actions.MessageTypeReceiveAction
import com.ddubson.hl7.actions.MessageVersionReceiveAction
import org.springframework.messaging.Message

class MessageReceiver(private val hl7Parser: Parser,
                      private val messageVersionReceiveAction: MessageVersionReceiveAction,
                      private val messageTypeReceiveAction: MessageTypeReceiveAction,
                      private val messageReceiveAction: MessageReceiveAction) {
    fun receive(message: Message<*>) {
        val hl7Msg = hl7Parser.parse(message.payload.toString()) as ADT_A01

        val message = ProcessedMessage(
                hl7Msg.pid.patientName[0].givenName.value,
                hl7Msg.pid.patientName[0].familyName.value,
                Sex.valueOf(hl7Msg.pid.sex.value),
                Race.valueOf(hl7Msg.pid.race.value.orEmpty()))
        messageReceiveAction.onMessageReceive(message)
        messageVersionReceiveAction.onMessageVersionReceive(hl7Msg.msh.versionID.value)
        messageTypeReceiveAction.onMessageTypeReceive(hl7Msg.msh.messageType.cm_msg1_MessageType.value)
    }
}