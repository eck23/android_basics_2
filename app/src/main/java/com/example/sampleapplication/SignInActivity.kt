package com.example.sampleapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.signin_screen)

        val signUpSwapTextButton= findViewById<TextView>(R.id.sign_up_swap)

        signUpSwapTextButton.setOnClickListener(){

            val intent= Intent(this, SignUpActivity::class.java)

            //naviagte to sign up page
            startActivity(intent)
            finish()

        }
    }

}