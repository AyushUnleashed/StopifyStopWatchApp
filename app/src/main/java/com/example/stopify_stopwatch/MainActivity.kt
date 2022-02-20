package com.example.stopify_stopwatch

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var alphaToGo: Animation;
    lateinit var btgone:Animation;
    lateinit var btgtwo:Animation;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load animation
        alphaToGo = AnimationUtils.loadAnimation(this,R.anim.alpha_to_go)
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone)
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo)


        //passing animation
        ivSplash.startAnimation(alphaToGo);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);
        btnGetStarted.startAnimation(btgtwo);

        btnGetStarted.setOnClickListener{
            val intent = Intent(this,StopwatchActivity::class.java);
            startActivity(intent);
        }
    }
}
