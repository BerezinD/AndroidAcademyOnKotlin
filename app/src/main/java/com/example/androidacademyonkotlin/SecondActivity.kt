package com.example.androidacademyonkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var counter = intent.getIntExtra("what is that?", 0)
        Toast.makeText(this,"$counter", Toast.LENGTH_LONG).show()
    }
}
