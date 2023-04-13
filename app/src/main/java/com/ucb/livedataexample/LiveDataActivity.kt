package com.ucb.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.ucb.data.MovieRepository
import com.ucb.domain.User
import com.ucb.framework.local.LocalDataSource
import com.ucb.framework.server.RetrofitBuilder
import com.ucb.framework.server.ServerDataSource
import com.ucb.usercases.GetPopularMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger
import kotlin.math.log
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
        session.user = User("Roberto Carlos", "Callisaya")

        val picasso = Picasso.get()
        picasso.load(
            "https://i.pinimg.com/564x/a8/6e/26/a86e26dffbcd0f8ffd0b7a6a4809ec68.jpg")
            .into(findViewById<ImageView>(R.id.imageView))


        button.setOnClickListener {
            liveDataString.changeValue((counter++).toString())

            GlobalScope.launch(Dispatchers.IO) {
                val lista = GetPopularMovies(MovieRepository(LocalDataSource(), ServerDataSource(RetrofitBuilder, getString(R.string.api_key)))).invoke()
                lista.forEach {
                    print(it.title)
                    Log.d("RESP POST", it.title)
                }
            }

        }

//        val restApiAdapter = RestApiAdapter1()
//        val endPoint = restApiAdapter.connectionApi()
//        val bookResponseCall = endPoint.getAllPost()
//        bookResponseCall.enqueue( object : Callback<List<Post>> {
//            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                Toast.makeText(this@LiveDataActivity, "Error", Toast.LENGTH_SHORT).show()
//                t?.printStackTrace()
//            }
//
//            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
//                val posts = response?.body()
//                Toast.makeText(this@LiveDataActivity, "Success", Toast.LENGTH_SHORT).show()
//
//                posts?.forEach {
//                    Log.d("RESP POST", it.body)
//                    Toast.makeText(this@LiveDataActivity, it.body, Toast.LENGTH_SHORT).show()
//                }
//            }
//        })

    }

    private fun updateUi(s: String) {
        textView.text = s
    }
}