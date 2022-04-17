package com.example.scheduleviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    val events = listOf(
        Event(
            "ECS 198F Android App Dev",
            "Lecture",
            LocalDateTime.of(2022, 4, 4, 16, 10),
            LocalDateTime.of(2022, 4, 4, 17, 0),
            "Wellman Hall 212"
        ),
        Event(
            "ECS 198F Android App Dev",
            "Lecture",
            LocalDateTime.of(2022, 4, 6, 16, 10),
            LocalDateTime.of(2022, 4, 6, 17, 0),
            "Wellman Hall 212"
        ),
        Event(
            "ECS 198F Android App Dev",
            "Office Hour",
            LocalDateTime.of(2022, 4, 5, 10, 30),
            LocalDateTime.of(2022, 4, 5, 11, 45),
            "Zoom"
        ),
        Event(
            "ECS 198F Android App Dev",
            "Office Hour",
            LocalDateTime.of(2022, 4, 7, 10, 30),
            LocalDateTime.of(2022, 4, 7, 11, 45),
            "Zoom"
        ),
        Event(
            "ECS 189A Quantum Computing",
            "Lecture",
            LocalDateTime.of(2022, 4, 5, 16, 40),
            LocalDateTime.of(2022, 4, 5, 18, 0),
            "Hoagland Hall 113"
        ),
        Event(
            "ECS 189A Quantum Computing",
            "Lecture",
            LocalDateTime.of(2022, 4, 7, 16, 40),
            LocalDateTime.of(2022, 4, 7, 18, 0),
            "Hoagland Hall 113"
        ),
    ).sortedBy { it.from }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = EventListRecyclerViewAdapter(events)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }

        findViewById<Switch>(R.id.officeHoursSwitch).apply {
            isChecked = true
            setOnCheckedChangeListener { _, checked ->
                adapter.updateEvents(when (checked) {
                    true -> events
                    false -> events.filter { it.type != "Office Hour" }
                })
            }
        }
    }
}