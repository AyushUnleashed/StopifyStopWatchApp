package com.example.stopify_stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_stopwatch.*
import kotlin.concurrent.timer

class StopwatchActivity : AppCompatActivity() {

    lateinit var roundingAlone:Animation;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        //create optional animation
        btnStop.alpha = 0F;

        //load animation
        roundingAlone = AnimationUtils.loadAnimation(this,R.anim.rounding_alone)

        btnStart.setOnClickListener{
            icAnchor.startAnimation(roundingAlone);
//            show stop button + move it up at start position
            btnStop.animate().alpha(1F).translationY(-60F).setDuration(300).start();
            //hide start button
            btnStart.animate().alpha(0F).setDuration(300).start();

            //start time
            timerHere.base = SystemClock.elapsedRealtime();
            timerHere.start();

            //diabling button
            btnStart.isEnabled = false;
        }

        btnStop.setOnClickListener{
            btnStart.isEnabled = true;
            icAnchor.clearAnimation()
            timerHere.stop();

            //            show stop button + move it up at start position
            btnStop.animate().alpha(0F).translationY(+60F).setDuration(300).start();
            //hide start button
            btnStart.animate().alpha(1F).setDuration(300).start();
        }
    }
}