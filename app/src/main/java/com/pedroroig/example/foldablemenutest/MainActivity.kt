package com.pedroroig.example.foldablemenutest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.GestureDetector
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewAdapter: AlertMessagesAdapter
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        initGestureDetector()
        initListeners()
    }

    private fun initRecyclerView() {
        viewAdapter = AlertMessagesAdapter(getMessagesList())
        val layoutManager = LinearLayoutManager(this)
        rvMessages.layoutManager = layoutManager
        rvMessages.adapter = viewAdapter
    }

    private fun initListeners() {

        alertIconContainer.setOnClickListener {
            foldUnfoldMessages()
        }

        rvMessages.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
        }
    }

    private fun initGestureDetector() {
        gestureDetector = GestureDetector(this, object :
            CustomGestureListener(rootLayout) {
            override fun onSwipeRight(): Boolean {
                return false
            }

            override fun onSwipeDown(): Boolean {
                return true
            }

            override fun onSwipeUp(): Boolean {
                foldUnfoldMessages()
                return true
            }

            override fun onSwipeLeft(): Boolean {
                return false

            }

            override fun onTouch(): Boolean {
                return false
            }
        })

    }

    private fun foldUnfoldMessages() {
        if (rvMessages.visibility == View.VISIBLE)
            rvMessages.visibility = View.GONE
        else
            rvMessages.visibility = View.VISIBLE
    }

    private fun getMessagesList() = listOf(
        "En raison des perturbations météorologiques de la semaine dernière, nous vous informons que les expéditions et les livraisons des colis sont perturbées. Nous vous remercions de votre compréhension et mettons tout en œuvre pour vous livrer dans les meilleurs délais ",
        "En raison des perturbations météorologiques de la semaine dernière, nous vous informons que les expéditions et les livraisons des colis sont perturbées. Nous vous remercions de votre compréhension et mettons tout en œuvre pour vous livrer dans les meilleurs délais ",
        "C'est un message d'alerte très court"
    )

}
