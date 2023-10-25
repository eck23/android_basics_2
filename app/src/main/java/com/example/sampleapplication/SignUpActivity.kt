package com.example.sampleapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.signup_screen)

        val signInSwapTextButton= findViewById<TextView>(R.id.sign_in_swap)

        signInSwapTextButton.setOnClickListener(){

            val intent =Intent(this,SignInActivity::class.java)
            //naviagte to sign in page
            startActivity(intent)
            finish()
        }
    }
}