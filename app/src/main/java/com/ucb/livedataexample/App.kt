package com.ucb.livedataexample

import android.app.Application
import com.ucb.livedataexample.session.Prefs

class App: Application() {
    companion object {
        var prefs: Prefs? = null
    }
    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}

val session: Prefs by lazy {
    App.prefs!!
}