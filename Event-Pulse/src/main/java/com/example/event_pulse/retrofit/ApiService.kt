package com.example.event_pulse.retrofit

import com.example.event_pulse.model.Event.EventRequest
import com.example.event_pulse.model.User.CommonResponse
import com.example.event_pulse.model.User.UserDataRequest
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    //Setting user data
    @POST("users/create")
    suspend fun postUserData(@Body userData : UserDataRequest): CommonResponse

    @POST("users/events")
    suspend fun postEvent(@Body eventRequest: EventRequest): CommonResponse

}