package com.github.fajaragungpramana.android

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.fajaragungpramana.sectionrecyclerview.SectionRecyclerViewAdapter
import com.github.fajaragungpramana.sectionrecyclerview.SectionRecyclerViewHolder

class MainAdapter(private val listName: List<Name>) :
    SectionRecyclerViewAdapter<MainAdapter.ViewHolder, Name>(listName) {

    override fun viewHolder(view: View) = ViewHolder(view)

    inner class ViewHolder(view: View) : SectionRecyclerViewHolder(view) {

        override fun bindSectionListAdapter(recyclerView: RecyclerView, position: Int) {
            recyclerView.adapter = NameAdapter(listName[position].listName)
        }

    }

}