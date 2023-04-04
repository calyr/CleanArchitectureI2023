package com.ucb.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.ucb.livedataexample.RestApiAdapter as RestApiAdapter1

class LiveDataActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textView: TextView
    lateinit var liveDataString: LiveDataString
    var counter: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        liveDataString = LiveDataString()
        button = findViewById(R.id.button2)
        textView = findViewById(R.id.textView2)
        liveDataString.model.observe(this, ::updateUi)

        button.setOnClickListener {
            liveDataString.changeValue((counter++).toString())
        }

        val restApiAdapter = RestApiAdapter1()
        val endPoint = restApiAdapter.connectionApi()
        val bookResponseCall = endPoint.getAllPost()
        bookResponseCall.enqueue( object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@LiveDataActivity, "Error", Toast.LENGTH_SHORT).show()
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response?.body()
                Toast.makeText(this@LiveDataActivity, "Success", Toast.LENGTH_SHORT).show()

                posts?.forEach {
                    Log.d("RESP POST", it.body)
                    Toast.makeText(this@LiveDataActivity, it.body, Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    private fun updateUi(s: String) {
        textView.text = s
    }
}