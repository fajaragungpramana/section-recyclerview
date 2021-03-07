package com.github.fajaragungpramana.sectionrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class SectionRecyclerViewAdapter<VH : SectionRecyclerViewHolder, M : Section>(private val listSection: List<M>) :
    RecyclerView.Adapter<VH>() {

    protected abstract fun viewHolder(view: View): VH

    override fun getItemCount() = listSection.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        viewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_section_recyclerview,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindSectionTitle(listSection[position].titleSection, position)
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

}