package com.example.androidacademyonkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

// do some stuff when main display (activity) creates
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    // set new values (with different syntax)
        var counter = 0
        val bigButton: Button = findViewById(R.id.bigButton)
        val createActivityButton = findViewById<Button>(R.id.openActivity)
        val sendEmailButton = findViewById<Button>(R.id.sendE_mail)
        val messageEditor = findViewById<TextView>(R.id.messageEditor)
        val textOnButton: TextView = findViewById(R.id.bigText)
        textOnButton.setText(R.string.on_first_button)
    // operate with "create activity" Button - put some data in the new activity
        createActivityButton.setOnClickListener {
            //this function lie in "SecondActivity" Class
            SecondActivity.openSecondActivity(this, counter, messageEditor.text.toString())
        }

    // operate with Big Button - increase counter on click
    // and, at the same moment - change text in View above
        bigButton.setOnClickListener{
                counter++
                textOnButton.text = "$counter"
    // then open second display (activity) with if, with data
            if (counter == 5) SecondActivity.openSecondActivity(this, counter, messageEditor.text.toString())
        }

    // operate with e-mail Button
        sendEmailButton.setOnClickListener{
            val sendEmailIntent = Intent(android.content.Intent.ACTION_SEND)
    // put some extras to new intent
            sendEmailIntent.type = "*/*"
            sendEmailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, arrayOf(getString(R.string.email_to)))
            sendEmailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.academy_on_kotlin))
            sendEmailIntent.putExtra(android.content.Intent.EXTRA_TEXT, messageEditor.text.toString())
    // create implicit intent - send e-mail
            startActivity(Intent.createChooser(sendEmailIntent, "SEND"))
        }
    }
}