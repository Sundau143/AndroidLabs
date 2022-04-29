package com.example.androidlabtask4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import android.content.Context

class WordSetAdapter(
    private val inflater: LayoutInflater
) : ListAdapter<MainActivity.WordSet, WordSetAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.setName)
        private val difficulty = view.findViewById<TextView>(R.id.difficulty)
        private val flag = view.findViewById<ImageView>(R.id.flag)

        fun bind(wordSet: MainActivity.WordSet) {
            name.text = wordSet.name
            difficulty.text = wordSet.difficulty
            flag.setImageResource(R.drawable.british)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wordSet = getItem(position)
        holder.bind(wordSet)
    }


    class DiffCallback : DiffUtil.ItemCallback<MainActivity.WordSet>() {
        override fun areItemsTheSame(
            oldItem: MainActivity.WordSet,
            newItem: MainActivity.WordSet
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainActivity.WordSet,
            newItem: MainActivity.WordSet
        ): Boolean = oldItem.name == newItem.name && oldItem.difficulty == newItem.difficulty
    }

}