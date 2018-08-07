package com.example.androidacademyonkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private val textOnButton: TextView = findViewById(R.id.bigText)
    private var counter: Int = 0
    private var infoOfUser = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textOnButton.setText(R.string.on_first_button)
        val bigButton: Button = findViewById(R.id.bigButton)
        bigButton.setOnClickListener{
                counter++
                textOnButton.setText("$counter")
        }
    }
}
