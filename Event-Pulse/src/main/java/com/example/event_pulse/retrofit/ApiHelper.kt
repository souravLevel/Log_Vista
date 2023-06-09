package com.example.event_pulse.retrofit

import com.example.event_pulse.model.User.UserDataRequest


class ApiHelper(private val apiService: ApiService) {

    suspend fun postUserData(userData: UserDataRequest) = apiService.postUserData(userData)

}

