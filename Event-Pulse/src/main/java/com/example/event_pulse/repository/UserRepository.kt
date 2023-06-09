package com.example.event_pulse.repository

import com.example.event_pulse.model.User.CommonResponse
import com.example.event_pulse.model.User.UserDataRequest
import com.example.event_pulse.retrofit.ApiHelper

class UserRepository(private val apiHelper: ApiHelper) {

    suspend fun postUserData(userDataRequest: UserDataRequest): CommonResponse = apiHelper.postUserData(userDataRequest)
}