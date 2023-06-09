package com.example.event_pulse

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.event_pulse.model.User.UserDataRequest
import com.example.event_pulse.retrofit.ApiHelper
import com.example.event_pulse.retrofit.RetrofitBuilder
import com.example.event_pulse.viewmodel.UserViewModel
import com.example.event_pulse.viewmodel.ViewModelFactory

public class EventLogix {

    public fun simpleToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    public fun setUpUser(context : Context, userDataRequest: UserDataRequest) {

        try {
            var viewModel = ViewModelProvider(
                context,
                ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
            ).get(
                UserViewModel::class.java
            )
            //   val viewModel =  ViewModelProvider(context, ViewModelFactory(ApiHelper(RetrofitBuilder.apiServiceMusicSleep))).get(MeditationViewModel::class.java)

            viewModel.(jwtToken).observe(context, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        SUCCESS -> {

                            resource.data?.let { resBody ->

                                SharePreferenceManager.getInstance(context)
                                    .save(Constants.CALL_MUSIC_API, true)
                                SharePreferenceManager.getInstance(context)
                                    .save(Constants.MUSIC_DATE, getTodaysDate())
                                var musicList = ArrayList<MusicList>()
                                musicList = resBody
                                val allPlaylist = ArrayList<ActivityResponseItem>()
                                val freePlaylist = ArrayList<ActivityResponseItem>()
                                musicList.forEach {
                                    allPlaylist.addAll(it.music)

                                    it.music.forEach {
                                        if (it.isPaid == 0) {
                                            freePlaylist.add(it)
                                        }
                                    }
                                }
                                val distinctList = allPlaylist.distinctBy { it.name }
                                allPlaylist.clear()
                                allPlaylist.addAll(distinctList)
//                            allPlaylist.shuffle()
                                musicList.add(0, MusicList("All", allPlaylist))
                                musicList.add(1, MusicList("Free", freePlaylist))
                                SharePreferenceManager.getInstance(context)
                                    .setClass(Constants.MUSIC_API_DATA, musicList)


                                if (imFrom == Constants.HOME) {
                                    if (context != null) {
//                                        (context as HomeActivity?)!!.hideLoader()
                                        HomeActivity.musicResponse.clear()
                                        HomeActivity.musicResponse = musicList
                                    }

                                }
                            }
                        }

                        ERROR -> {
//                            if(context != null){
//                                if (imFrom == Constants.HOME) {
//                                    (context as HomeActivity?)!!.hideLoader()
//                                }
//                            }
                            //  isNetworkAvailable(context)
                        }

                        LOADING -> {
//                            if(context != null){
//                                if (imFrom == Constants.HOME) {
//                                    (context as HomeActivity?)!!.showLoader()
//                                }
//                            }
                        }
                    }
                }
            })
        } catch (e: Exception) {
        }
    }
}