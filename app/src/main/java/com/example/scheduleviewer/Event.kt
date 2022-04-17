package com.example.scheduleviewer

import java.time.LocalDateTime

data class Event(
    var title: String,
    var type: String,
    var from: LocalDateTime,
    var to: LocalDateTime,
    var location: String
)
