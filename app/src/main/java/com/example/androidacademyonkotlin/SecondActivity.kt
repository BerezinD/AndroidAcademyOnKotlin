package com.example.androidacademyonkotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    companion object {
        var infoOfUser = ""

        fun openSecondActivity(activity: Activity, counter: Int, textMessage: String = "") {
            val secondActivityIntent = Intent(activity, SecondActivity::class.java)

            secondActivityIntent.putExtra(infoOfUser, counter)
            secondActivityIntent.putExtra("textMessage", textMessage)

            activity.startActivity(secondActivityIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val counter = intent.getIntExtra(infoOfUser, 0)
        val textToSecondActivity = intent.getStringExtra("textMessage")
        val secondBigTextView = findViewById<TextView>(R.id.second_big_text)

        Toast.makeText(this, textToSecondActivity, Toast.LENGTH_LONG).show()
        Toast.makeText(this, "${getString(R.string.current_counter_is)} $counter", Toast.LENGTH_LONG).show()
        secondBigTextView.text = textToSecondActivity
        secondBigTextView.textSize = 62.5f
    }
}
