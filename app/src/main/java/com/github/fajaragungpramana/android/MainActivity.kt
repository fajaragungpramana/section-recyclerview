package com.github.fajaragungpramana.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_main)

        val listName = mutableListOf(
            Name(
                1,
                "01/01/2021",
                listOf("A", "B", "C", "D", "E")
            ),
            Name(
                2,
                "01/02/2021",
                listOf("F", "G", "H", "I", "J")
            ),
            Name(
                3,
                "01/03/2021",
                listOf("K", "L", "M", "N", "O")
            )
        )

        recyclerView.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = MainAdapter(listName)
        }

    }

}