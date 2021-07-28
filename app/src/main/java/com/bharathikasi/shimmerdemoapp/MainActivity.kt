package com.bharathikasi.shimmerdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var mImageView1:AppCompatImageView
    private lateinit var mShineImageView2:AppCompatImageView
    private lateinit var mParent : RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mImageView1 = findViewById(R.id.Image1)
        mShineImageView2 = findViewById(R.id.shineImage)
        mParent = findViewById(R.id.Parent)

        var lShceduleExecutionerService = Executors.newSingleThreadScheduledExecutor()
        lShceduleExecutionerService.scheduleAtFixedRate(object : Runnable {
            override fun run() {
                runOnUiThread(object : Runnable {
                    override fun run() {
                        shineStart()
                    }

                })
            }
        }, 3, 3, TimeUnit.SECONDS)
    }

    private fun shineStart(){
        var lAnimation = TranslateAnimation(0F,(mParent.width+mShineImageView2.width).toFloat(),0F,0F)
        lAnimation.duration = 550
        lAnimation.fillAfter = false
        lAnimation.interpolator = AccelerateDecelerateInterpolator()
        mShineImageView2.startAnimation(lAnimation)
    }
}