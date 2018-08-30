package com.example.androidacademyonkotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    // create static object - for call it from other activity
    companion object {
        var infoOfUser = ""
        // function for create new activity
        fun openSecondActivity(activity: Activity, counter: Int, textMessage: String = "") {
            val secondActivityIntent = Intent(activity, SecondActivity::class.java)

            // put some data to new activity
            secondActivityIntent.putExtra(infoOfUser, counter)
            secondActivityIntent.putExtra("textMessage", textMessage)

            activity.startActivity(secondActivityIntent)
        }
    }

    // function to show toast with custom settings and layout
    private fun showCustomToast(textMessage: String){
        val inflater = layoutInflater
        val layout: View = inflater.inflate(R.layout.custom_toast, null)
        val text: TextView = layout.findViewById(R.id.tvTitle)
            text.text = textMessage
        val image: ImageView = layout.findViewById(R.id.image)
            image.setImageResource(R.mipmap.ic_launcher_round)
        val toast = Toast(this)
            toast.view = layout
            toast.setGravity(Gravity.TOP, 50, 100)
            toast.show()
    }

    // do some stuff when main display (activity) creates
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // set new values to extract data from previous activity
        val counter = intent.getIntExtra(infoOfUser, 0)
        val textToSecondActivity = intent.getStringExtra("textMessage")
        val secondBigTextView = findViewById<TextView>(R.id.second_big_text)

        // show toast and fill Text field
        showCustomToast(textToSecondActivity)
        showCustomToast("${getString(R.string.current_counter_is)} $counter")
        secondBigTextView.text = textToSecondActivity
        secondBigTextView.textSize = 62.5f
    }
}
