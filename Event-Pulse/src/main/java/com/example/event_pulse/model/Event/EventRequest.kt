package com.example.event_pulse.model.Event

import com.example.event_pulse.model.User.AdditionalProperties

data class EventRequest(
    var user_id : String,
    var from_where : String,
    var sub_section : String,
    var activity_type : String,
    var purpose : String,
    var activity_id : Int,
    var activity_name : String,
    var did : String,
    var activity_url : String
)

data class EventDetails(
    var name : String,
    var url : String
)
//
//{
//    "user_id": "8c36cdcf-5239-11ee-bb62-0ad32c43ca74",
//    "from_where": "Today",
//    "sub_section": "Trending",
//    "activity_type": "Meditation",
//    "purpose": "Start",
//    "activity_id": 2,
//    "activity_name":"Victorious Breath",
//    "did": "8cdecab992ac3c8a",
//    "activity_url": "https://v3.cdn.level.game/meditations/1692705443212_Andrei+Ujjayi+Breathing_03+%281%29.mp3"
//}