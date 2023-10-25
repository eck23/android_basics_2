package com.example.sampleapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.welcome_screen)

        val topAnimation= AnimationUtils.loadAnimation(this, R.anim.welcome_animation_top)
        val bottomAnimation= AnimationUtils.loadAnimation(this, R.anim.welcome_animation_bottom)
        topAnimation.duration=1000
        bottomAnimation.duration=1000


        val welcomeImage = findViewById<ImageView>(R.id.welcomeImage)
        val welcomeTextSection1 = findViewById<TextView>(R.id.welcome_section1)
        val welcomeTextSection2 = findViewById<TextView>(R.id.welcome_section2)
        val welcomeTextSection3 = findViewById<TextView>(R.id.welcome_section3)
        val welcomeButton = findViewById<Button>(R.id.welcome_button)


        welcomeImage.animation=topAnimation
        welcomeTextSection1.animation=bottomAnimation
        welcomeTextSection2.animation=bottomAnimation
        welcomeTextSection3.animation=bottomAnimation
        welcomeButton.animation=bottomAnimation


        welcomeButton.setOnClickListener(){

            val  intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent);
            finish()
        }




    }

}