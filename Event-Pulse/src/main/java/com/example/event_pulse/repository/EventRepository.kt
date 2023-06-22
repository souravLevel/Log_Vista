package com.example.event_pulse.repository

import com.example.event_pulse.model.Event.EventRequest
import com.example.event_pulse.model.User.CommonResponse
import com.example.event_pulse.model.User.UserDataRequest
import com.example.event_pulse.retrofit.ApiHelper

class EventRepository(private val apiHelper: ApiHelper)  {
    suspend fun postEvent(eventRequest: EventRequest): CommonResponse = apiHelper.postEvent(eventRequest)
}