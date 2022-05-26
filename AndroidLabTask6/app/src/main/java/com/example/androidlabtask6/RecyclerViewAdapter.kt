package com.example.androidlabtask6

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class RecyclerViewAdapter internal constructor(context: Context?, data: Array<String>, colors: Array<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val itemData: Array<String> = data
    private val itemColors: Array<String> = colors
    private val itemInflater: LayoutInflater = LayoutInflater.from(context)
    private var mClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = itemInflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    } 

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myTextView.text = itemData[position]
        val bg = holder.itemView.background
        if (bg is GradientDrawable)
            bg.setColor(Color.parseColor(itemColors.random()))

    }

    override fun getItemCount(): Int {
        return itemData.size
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var myTextView: TextView = itemView.findViewById(R.id.info_text)
        override fun onClick(view: View?) {
            if (mClickListener != null)
                mClickListener!!.onItemClick(view, myTextView.text.toString())
        }
        init {
            itemView.setOnClickListener(this)
        }
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        mClickListener = itemClickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, number: String)
    }

}