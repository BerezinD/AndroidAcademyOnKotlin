package com.example.androidacademyonkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter: Int = 0
        val textOnButton: TextView = findViewById(R.id.bigText)
        val bigButton: Button = findViewById(R.id.bigButton)
        val createActivityButton = findViewById<Button>(R.id.openActivity)
        val sendEmailButton = findViewById<Button>(R.id.sendE_mail)
        val messageEditor = findViewById<TextView>(R.id.messageEditor)

        textOnButton.setText(R.string.on_first_button)

        createActivityButton.setOnClickListener {
            SecondActivity.openSecondActivity(this, counter, messageEditor.text.toString())
        }

        bigButton.setOnClickListener{
                counter++
                textOnButton.setText("$counter")
            if (counter==5) SecondActivity.openSecondActivity(this, counter)
        }
    }
}
