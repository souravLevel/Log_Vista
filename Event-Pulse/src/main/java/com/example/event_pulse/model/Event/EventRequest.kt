package com.example.event_pulse.model.Event

import com.example.event_pulse.model.User.AdditionalProperties

data class EventRequest(
    var user_id : String,
    var event_name : String,
    var did : String,
    var origin : String,
    var event_details : EventDetails
)

data class EventDetails(
    var name : String,
    var url : String
)
