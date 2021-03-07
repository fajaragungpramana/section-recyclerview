package com.github.fajaragungpramana.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NameAdapter(private val listName: List<String>) :
    RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    override fun getItemCount() = listName.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindName(listName[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.name_adapter,
                parent,
                false
            )
        )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mName by lazy { view.findViewById<TextView>(R.id.tv_name) }

        fun bindName(name: String) {
            mName.text = name
        }

    }

}