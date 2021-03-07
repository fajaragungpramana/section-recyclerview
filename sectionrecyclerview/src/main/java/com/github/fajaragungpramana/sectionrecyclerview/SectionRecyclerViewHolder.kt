package com.github.fajaragungpramana.sectionrecyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class SectionRecyclerViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView) {

    private val mSectionTitle by lazy { mView.findViewById<TextView>(R.id.tv_section_title) }
    private val mSectionList by lazy { mView.findViewById<RecyclerView>(R.id.rv_section_list) }

    fun bindSectionTitle(title: String, position: Int) {
        mSectionTitle.text = title

        bindSectionListAdapter(mSectionList.also {
            it.layoutManager = LinearLayoutManager(mView.context)
        }, position)
    }

    abstract fun bindSectionListAdapter(recyclerView: RecyclerView, position: Int)

}