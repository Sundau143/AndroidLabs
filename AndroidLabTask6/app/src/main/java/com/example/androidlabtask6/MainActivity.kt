package com.example.androidlabtask6

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), RecyclerViewAdapter.ItemClickListener {
    private var adapter: RecyclerViewAdapter? = null

    private val elementsNumber = 24;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // generate 24 random numbers
        val data = Array<String>(elementsNumber) { (1..100).random().toString() }
        // 5 random different colors for cells
        val colors = arrayOf("#ff595e", "#ffca3a", "#8ac926", "#1982c4", "#6a4c93")

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvNumbers)
        val numberOfColumns = 4
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        adapter = RecyclerViewAdapter(this, data, colors)
        adapter!!.setClickListener(this)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.margin))
        )

    }

    override fun onItemClick(view: View?, number: String) {
        val itemDialog = OnClickDialog(number.toString())
        itemDialog.show(supportFragmentManager, "itemDialog")
    }
}