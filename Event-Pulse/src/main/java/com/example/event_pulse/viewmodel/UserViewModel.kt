package com.example.event_pulse.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.event_pulse.model.User.UserDataRequest
import com.example.event_pulse.repository.UserRepository
import com.example.event_pulse.retrofit.Resource
import kotlinx.coroutines.Dispatchers

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {


    fun postUserData(userDataRequest: UserDataRequest) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.postUserData(userDataRequest)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}