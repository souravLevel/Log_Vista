package com.example.event_pulse

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.event_pulse.model.Event.EventRequest
import com.example.event_pulse.retrofit.ApiHelper
import com.example.event_pulse.retrofit.RetrofitBuilder
import com.example.event_pulse.retrofit.Status
import com.example.event_pulse.viewmodel.EventViewModel
import com.example.event_pulse.viewmodel.ViewModelFactory


public class EventLogix {

    public fun simpleToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    public fun callEvent(
        context: Context,
        uuid: String,
        fromWhere: String,
        subSection: String,
        activityType: String,
        purpose: String,
        activityId: Int,
        activityName: String,
        deviceId: String,
        activityUrl: String
    ) {

        //val eventDetails = EventDetails(activityName, activityUrl)
        val eventRequest = EventRequest(
            uuid,
            fromWhere,
            subSection,
            activityType,
            purpose,
            activityId,
            activityName,
            deviceId,
            activityUrl
        )

        val viewModel = ViewModelProvider(
            context as ViewModelStoreOwner,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        )[EventViewModel::class.java]

        viewModel.postEvent(eventRequest).observe(context as LifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { resBody ->
                           // simpleToast(context, "Success")
                        }
                    }

                    Status.ERROR -> {
                        //requireContext().showToastMsg("Error MoodTracker " + it.message)

                    }

                    Status.LOADING -> {
                    }
                }
            }
        })
    }


}