package com.example.scheduleviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventListRecyclerViewAdapter(private var events: List<Event>)
    : RecyclerView.Adapter<EventListRecyclerViewAdapter.ViewHolder>() {

    fun updateEvents(events: List<Event>) {
        this.events = events
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.eventTitleTextView)
        val typeTextView: TextView = itemView.findViewById(R.id.eventTypeTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.eventTimeTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.eventLocationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.event_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]

        holder.apply {
            titleTextView.text = event.title
            typeTextView.text = event.type
            timeTextView.text = "${event.from.toLocalDate()} ${event.from.toLocalTime()} - ${event.to.toLocalTime()}"
            locationTextView.text = event.location
        }
    }

    override fun getItemCount() = events.size
}