package com.ddubson.hl7.messageProcessing

data class ProcessedMessage(val firstName: String,
                            val lastName: String,
                            val sex: Sex,
                            val race: String) {
}