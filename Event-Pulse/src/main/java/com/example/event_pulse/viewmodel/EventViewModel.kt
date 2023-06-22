package com.example.event_pulse.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.event_pulse.model.Event.EventRequest
import com.example.event_pulse.model.User.UserDataRequest
import com.example.event_pulse.repository.EventRepository
import com.example.event_pulse.repository.UserRepository
import com.example.event_pulse.retrofit.Resource
import kotlinx.coroutines.Dispatchers

class EventViewModel(
    private val repository: EventRepository
) : ViewModel() {


    fun postEvent(eventRequest: EventRequest) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.postEvent(eventRequest)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}