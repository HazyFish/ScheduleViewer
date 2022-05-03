package com.example.scheduleviewer

import java.time.LocalDateTime

data class Event(
    val id: Int,
    var title: String,
    var type: String,
    var start: LocalDateTime,
    var end: LocalDateTime,
    var location: String
)
