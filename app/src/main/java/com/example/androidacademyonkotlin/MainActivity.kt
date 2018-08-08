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
        val textOnButton: TextView = findViewById(R.id.bigText)
        var counter: Int = 0
        var infoOfUser = ""

        fun openActivity(){
            val secondActivityIntent: Intent = Intent(this, SecondActivity::class.java)
            startActivity(secondActivityIntent)
            secondActivityIntent.putExtra("what is that?", counter)
        }

        textOnButton.setText(R.string.on_first_button)
        val bigButton: Button = findViewById(R.id.bigButton)
        bigButton.setOnClickListener{
                counter++
                textOnButton.setText("$counter")
            if (counter==5) openActivity()
        }
    }
}
