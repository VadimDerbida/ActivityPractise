package com.dg.lesson2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ui_design_practise.*

class UiDesignPractise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_design_practise)
        backToMenuButton.setOnClickListener {
            backToMenu()
        }
        change_color()
    }
    private fun backToMenu() {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
    }
    private fun change_color() {
        view1.setOnClickListener { view1.setBackgroundColor(Color.parseColor("#4a1619"))}
        view2.setOnClickListener { view2.setBackgroundColor(Color.parseColor("#203d20"))}
        view3.setOnClickListener { view3.setBackgroundColor(Color.parseColor("#17e332"))}
        view4.setOnClickListener { view4.setBackgroundColor(Color.parseColor("#0fcbf5"))}
        view5.setOnClickListener { view5.setBackgroundColor(Color.parseColor("#ed001c"))}
        view6.setOnClickListener { view6.setBackgroundColor(Color.parseColor("#ed001c"))}
        view7.setOnClickListener { view7.setBackgroundColor(Color.parseColor("#ed001c"))}
        view8.setOnClickListener { view8.setBackgroundColor(Color.parseColor("#ed001c"))}
        view9.setOnClickListener { view9.setBackgroundColor(Color.parseColor("#ed001c"))}
        view10.setOnClickListener { view10.setBackgroundColor(Color.parseColor("#ed001c"))}
        view11.setOnClickListener { view11.setBackgroundColor(Color.parseColor("#ed001c"))}
        view12.setOnClickListener { view12.setBackgroundColor(Color.parseColor("#ed001c"))}
    }
}