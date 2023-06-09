package com.example.event_pulse.model.User

data class UserDataRequest(
    val country_code: String,
    val time_zone: String,
    val last_name: String,
    val first_name: String,
    val email: String,
    val phone: String,
    val additional_properties: AdditionalProperties
)

data class AdditionalProperties(
    val location: String,
)

data class CommonResponse(
    val id : Int,
    val message : String
)