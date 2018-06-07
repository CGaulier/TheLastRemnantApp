package com.example.clemence.thelappremnant

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class TheLastRemnantApp: Application() {

    companion object {

        lateinit var queue: RequestQueue

    }

    override fun onCreate() {

        super.onCreate()
        queue = Volley.newRequestQueue(this)

    }

}