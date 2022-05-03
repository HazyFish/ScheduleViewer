package com.example.scheduleviewer

import retrofit2.Call
import retrofit2.http.*

interface ScheduleService {
    @GET("/events")
    fun listEvents(@Query("includesOfficeHours") includesOfficeHours: Boolean): Call<List<Event>>

    @POST("/events")
    fun createEvent(@Body event: Event): Call<Unit>

    @GET("/events/{id}")
    fun getEvent(@Path("id") id: Int): Call<Event>

    @GET("/events/{id}")
    fun deleteEvent(@Path("id") id: Int): Call<Unit>
}