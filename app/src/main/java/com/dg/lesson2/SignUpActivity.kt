package com.dg.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupUi()
    }

    private fun setupUi() {


        val nameInput = findViewById<TextInputEditText>(R.id.name_text_input)
        val surnameInput = findViewById<TextInputEditText>(R.id.surname_text_input)
        val email_textInput = findViewById<TextInputEditText>(R.id.e_mail_text_input)
        val passwordInput = findViewById<TextInputEditText>(R.id.password_text_input)
        val loginButton = findViewById<MaterialButton>(R.id.confirm_button)
        val confirmPasswordInput = findViewById<TextInputEditText>(R.id.confirm_password_text_input)
        loginButton.setOnClickListener {
            if (passwordInput.text.toString() == confirmPasswordInput.text.toString()) {

                if (nameInput.text.isNullOrBlank() || passwordInput.text.isNullOrBlank()) {
                    Toast.makeText(this, "Name / password cannot be empty", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    if ("@" in email_textInput.text.toString()) {
                        login(
                            name = nameInput.text.toString(),
                            password = passwordInput.text.toString(),
                            surname = surnameInput.text.toString(),
                            email = email_textInput.text.toString()
                        )
                    } else {
                        Toast.makeText(this, "Email was not correct", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                Toast.makeText(this, "Password was not confirmed", Toast.LENGTH_SHORT).show()
            }
        }

        val showHideBtn = findViewById<Button>(R.id.showHideBtn)
        val password_text_input = findViewById<TextInputEditText>(R.id.password_text_input)
        showHideBtn.setOnClickListener {
            if (showHideBtn.text.toString().equals("Show password")) {
                password_text_input.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                showHideBtn.text = "Hide password"
            } else {
                password_text_input.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                showHideBtn.text = "Show password"
            }
        }
    }

    private fun login(name: String, password: String, surname: String, email: String) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("surname", surname)
        intent.putExtra("email", email)
        intent.putExtra("password", password)
        startActivity(intent)
    }

}