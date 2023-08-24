package com.dg.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val task_1 = findViewById<Button>(R.id.task_1)
        task_1.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val task_2 = findViewById<Button>(R.id.task_2)
        task_2.setOnClickListener {
            val intent = Intent(this, Calculator::class.java)
            startActivity(intent)
        }

        val task_3 = findViewById<Button>(R.id.task_3)
        task_3.setOnClickListener {
            val intent = Intent(this, UiDesignPractise::class.java)
            startActivity(intent)
        }
    }

}