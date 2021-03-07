package com.github.fajaragungpramana.android

import com.github.fajaragungpramana.sectionrecyclerview.Section

data class Name(
    val id: Int,
    val date: String,
    val listName: List<String>
) : Section(date)