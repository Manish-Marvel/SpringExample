package com.wrapx.exampleapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent.ACTION_UP
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout.LayoutParams;


class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val text:TextView= findViewById(R.id.text);
//        val windowWidth = windowManager.defaultDisplay.width;
//        val windowHeight = windowManager.defaultDisplay.height;
//        text.setOnTouchListener(OnTouchListener { v, event ->
//            val layoutParams: LayoutParams = text.layoutParams as LayoutParams
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> {
//                }
//                MotionEvent.ACTION_MOVE -> {
//                    var x_cord = event.rawX.toInt()
//                    var y_cord = event.rawY.toInt()
//                    if (x_cord > windowWidth) {
//                        x_cord = windowWidth
//                    }
//                    if (y_cord > windowHeight) {
//                        y_cord = windowHeight
//                    }
//                    layoutParams.leftMargin = x_cord - 25
//                    layoutParams.topMargin = y_cord - 75
//                    text.setLayoutParams(layoutParams)
//                }
//                MotionEvent.ACTION_UP ->{
//                    layoutParams.leftMargin = 25
//                    layoutParams.topMargin = 75
//                    text.setLayoutParams(layoutParams)
//                }
//                else -> {
//                }
//            }
//            true
//        })
            }
}