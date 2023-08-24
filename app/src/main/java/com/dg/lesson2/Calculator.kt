package com.dg.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        zero_btn.setOnClickListener { setTextFields("0", ochistka = true) }
        one_btn.setOnClickListener { setTextFields("1", ochistka = true) }
        two_btn.setOnClickListener { setTextFields("2", ochistka = true) }
        three_btn.setOnClickListener { setTextFields("3", ochistka = true) }
        four_btn.setOnClickListener { setTextFields("4", ochistka = true) }
        five_btn.setOnClickListener { setTextFields("5", ochistka = true) }
        six_btn.setOnClickListener { setTextFields("6", ochistka = true) }
        seven_btn.setOnClickListener { setTextFields("7", ochistka = true) }
        eight_btn.setOnClickListener { setTextFields("8", ochistka = true) }
        nine_btn.setOnClickListener { setTextFields("9", ochistka = true) }
        min_btn.setOnClickListener { setTextFields("-", ochistka = false) }
        plus_btn.setOnClickListener { setTextFields("+", ochistka = false) }
        divide_btn.setOnClickListener { setTextFields("/", ochistka = false) }
        mult_btn.setOnClickListener { setTextFields("*", ochistka = false) }
        brk1_btn.setOnClickListener { setTextFields("(", ochistka = false) }
        brk2_btn.setOnClickListener { setTextFields(")", ochistka = false) }
        dot_btn.setOnClickListener { setTextFields(".", ochistka = false) }

        AC_btn.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""

        }

        del_btn.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)
            result_text.text = ""

        }

        equals_btn.setOnClickListener {
            try {

                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()

            } catch (e: Exception) {
                Log.d("Ошибка ", "сообщение: ${e.message}")

            }
        }
    }

    fun setTextFields(str: String, ochistka: Boolean) {
        if (result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }

        math_operation.append(str)
    }
}


