package com.ucb.livedataexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ucb.domain.Movie

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movie: Movie = Movie("/hlkjlkj/jddf.jpg","El padrino")
        button = findViewById(R.id.button)

        button.setOnClickListener {
            counter++
            findViewById<TextView>(R.id.textView).text = counter.toString()
        }
    }


}