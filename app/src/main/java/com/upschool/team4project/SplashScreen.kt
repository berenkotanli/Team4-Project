package com.upschool.team4project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val topAnimation=AnimationUtils.loadAnimation(this,R.anim.top_animatior)
        val middleAnimation=AnimationUtils.loadAnimation(this,R.anim.middle_animation)
        val bottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        imageView.startAnimation(topAnimation)
        textViewSplash.startAnimation(middleAnimation)
        textViewSplashSlogan.startAnimation(bottomAnimation)

        val splashScreenTimeOut=4000
        val homeIntent=Intent(this@SplashScreen, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        },splashScreenTimeOut.toLong())
    }
}