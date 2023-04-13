package com.ucb.livedataexample.session

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.ucb.domain.User

class Prefs(context: Context) {
    private val PREFS_FILENAME = "edu.bo.ucb.pref"
    private val KEY_USER ="user"
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)
    //    var user: String?
//        get() = prefs.getString(KEY_USER, null)
//        set(value) = prefs.edit().putString(KEY_USER, value).apply()
    var user: User
        get() {
            val gson = Gson()
            //  Gson gson = new Gson();
            return gson.fromJson(prefs.getString(KEY_USER, null), User::class.java) }
        set(value) {
            val gson = Gson()
            // Gson gson = new Gson();
            val userJson = gson.toJson(value)
            // String userJson =gson.toJson(value);
            prefs.edit().putString(KEY_USER, userJson).apply()
        }
}

