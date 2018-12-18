package com.pedroroig.example.foldablemenutest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewAdapter: AlertMessagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        viewAdapter = AlertMessagesAdapter(getMessagesList())
        val layoutManager = LinearLayoutManager(this)
        rvMessages.layoutManager = layoutManager
        rvMessages.adapter = viewAdapter
    }

    private fun getMessagesList() = listOf(
        "En raison des perturbations météorologiques de la semaine dernière, nous vous informons que les expéditions et les livraisons des colis sont perturbées. Nous vous remercions de votre compréhension et mettons tout en œuvre pour vous livrer dans les meilleurs délais ",
        "En raison des perturbations météorologiques de la semaine dernière, nous vous informons que les expéditions et les livraisons des colis sont perturbées. Nous vous remercions de votre compréhension et mettons tout en œuvre pour vous livrer dans les meilleurs délais ",
        "C'est un message d'alerte très court")

}
