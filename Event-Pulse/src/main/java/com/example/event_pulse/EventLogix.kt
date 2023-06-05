package com.example.event_pulse

import android.content.Context
import android.widget.Toast

public class EventLogix {

    public fun simpleToast(context : Context, message : String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}