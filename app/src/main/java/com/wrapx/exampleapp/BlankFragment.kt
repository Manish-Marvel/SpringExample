package com.wrapx.exampleapp

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce


class BlankFragment : Fragment() {
    private companion object Params {
        val STIFFNESS = SpringForce.STIFFNESS_MEDIUM
        val DAMPING_RATIO = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
    }

    lateinit var xAnimation: SpringAnimation
    lateinit var yAnimation: SpringAnimation

    var root:LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val windowWidth = requireActivity().windowManager.defaultDisplay.width;
        val windowHeight = requireActivity().windowManager.defaultDisplay.height;

        root?.viewTreeObserver?.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
//                xAnimation = root?.x?.let {
//                    createSpringAnimation(
//                        root!!, SpringAnimation.X, it, STIFFNESS, DAMPING_RATIO)
//                }!!
                yAnimation = root?.y?.let {
                    createSpringAnimation(
                        root!!, SpringAnimation.Y, it, STIFFNESS, DAMPING_RATIO)
                }!!
                root!!.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })


//        var dX = 0f
        var dY = 0f
        root?.setOnTouchListener(View.OnTouchListener { v, event ->
//            val layoutParams: LinearLayout.LayoutParams =
//                root?.layoutParams as LinearLayout.LayoutParams
//            var y=event.rawY.toInt()
//            var x=event.rawX.toInt()
            var Y=0
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
//                    Log.e("Tag","Down")
//                    Log.e("down", "$x : $y")
//                  Y=y;
//                    dX = view.x - event.rawX
                    dY = view.y - event.rawY

                    // cancel animations so we can grab the view during previous animation
//                    xAnimation.cancel()
                    yAnimation.cancel()
                }
                MotionEvent.ACTION_MOVE -> {
//                    var x_cord = event.rawX.toInt()
//                    var y_cord = event.rawY.toInt()
//                    Log.e("move", "$x : $y")
//                    if (x_cord > windowWidth) {
//                        x_cord = windowWidth
//                    }
//
////                    layoutParams.topMargin = y_cord - 75
////                    root?.setLayoutParams(layoutParams)
//                    ObjectAnimator.ofFloat(root, "translationY", (y).toFloat()).apply {
//                        duration = 50
//                        start()
//                    }
                    Log.e("Move : ",(event.rawY - dY).toString())
                    root!!.animate()
//                        .x(event.rawX + dX)
                        .y(event.rawY + dY)
                        .setDuration(0)
                        .start()
                }
                MotionEvent.ACTION_UP -> {
//                    Log.e("Tag","UP")
//                    Log.e("up", "$x : $y")
//                    ObjectAnimator.ofFloat(root, "translationY", (Y).toFloat()).apply {
//                        duration = 1000
//                        start()
//                    }
//                    xAnimation.start()
                    yAnimation.start()
                }
                else -> {
                }
            }
            true
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_blank, container, false)
        root = view?.findViewById(R.id.root)
        return view;
    }



    fun createSpringAnimation(view: View,
                              property: DynamicAnimation.ViewProperty,
                              finalPosition: Float,
                              stiffness: Float,
                              dampingRatio: Float): SpringAnimation {
        val animation = SpringAnimation(view, property)
        val spring = SpringForce(finalPosition)
        spring.stiffness = stiffness
        spring.dampingRatio = dampingRatio
        animation.spring = spring
        return animation
    }
}