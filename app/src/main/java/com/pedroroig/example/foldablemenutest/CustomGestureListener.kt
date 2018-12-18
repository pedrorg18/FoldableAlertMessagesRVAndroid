package com.pedroroig.example.foldablemenutest

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

/**
 * CustomGestureListener is a listener which provides different actions in function of the touch events provided by a user
 */
abstract class CustomGestureListener(private val mView: View) : GestureDetector.SimpleOnGestureListener() {

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
        mView.onTouchEvent(e)
        return super.onSingleTapConfirmed(e)
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        onTouch()
        return false
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {

        if (e1.x < e2.x) {
            onSwipeRight()
        }

        if (e1.y < e2.y) {
            onSwipeDown()
        }

        if (e1.y > e2.y) {
            onSwipeUp()
        }

        if (e1.x > e2.x) {
            onSwipeLeft()
        }
        return onTouch()
    }

    abstract fun onSwipeRight(): Boolean
    abstract fun onSwipeLeft(): Boolean
    abstract fun onSwipeDown(): Boolean
    abstract fun onSwipeUp(): Boolean
    abstract fun onTouch(): Boolean
}