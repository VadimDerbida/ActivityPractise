package com.dg.lesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.text.method.PasswordTransformationMethod;

class ProfileActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var imageView: ImageView

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupUi()


        button = findViewById(R.id.btn_pick_img)
        imageView = findViewById(R.id.img_save)
        button.setOnClickListener {
            pickImageGallery()
        }

    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            imageView.setImageURI(data?.data)
        }
    }

    private fun setupUi() {
        val nameTextView = findViewById<TextView>(R.id.name_text)
        val surname = findViewById<TextView>(R.id.surname_text)
        val email = findViewById<TextView>(R.id.email_text)
        val passwordTextView = findViewById<TextView>(R.id.password_text)
        val signOutButton = findViewById<MaterialButton>(R.id.sign_out_button)
        val data = intent.extras
        if (data != null) {
            nameTextView.text = data.getString("name")
            surname.text = data.getString("surname")
            email.text = data.getString("email")
            val string = passwordTextView.text
            string.forEach {
                passwordTextView.transformationMethod = PasswordTransformationMethod.getInstance()
                passwordTextView.text = data.getString("password")
            }
        }

        signOutButton.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

}