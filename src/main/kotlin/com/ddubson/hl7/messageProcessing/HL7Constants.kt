package com.ddubson.hl7.messageProcessing

enum class Sex(val sex: String) {
    M("Male"),
    F("Female"),
    O("Other"),
    U("Unknown");
}

class Race {
    companion object {
        private val races = hashMapOf(
                Pair("1002-5", "American Indian or Alaska Native"),
                Pair("2028-9", "Asian"),
                Pair("2054-5", "Black or African-American"),
                Pair("2076-8", "Native Hawaiian or Other Pacific Islander"),
                Pair("2106-3", "White"),
                Pair("2131-1", "Other Race"),
                Pair("2135-2", "Hispanic or Latino"),
                Pair("2186-5", "not Hispanic or Latino"))

        fun valueOf(raceCode: String): String {
            return races[raceCode].orEmpty()
        }
    }
}