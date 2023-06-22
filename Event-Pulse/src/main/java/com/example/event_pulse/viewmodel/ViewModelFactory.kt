package com.example.event_pulse.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.event_pulse.repository.EventRepository
import com.example.event_pulse.repository.UserRepository
import com.example.event_pulse.retrofit.ApiHelper

class ViewModelFactory(
    private val apiHelper: ApiHelper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(UserRepository(apiHelper)) as T
        } else if (modelClass.isAssignableFrom(EventViewModel::class.java)) {
            return EventViewModel(EventRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

