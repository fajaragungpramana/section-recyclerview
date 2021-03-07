# Android Section Recycler View
[![](https://jitpack.io/v/fajaragungpramana/section-recyclerview.svg)](https://jitpack.io/#fajaragungpramana/section-recyclerview)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
</br>
</br>
Library for android. RecyclerView adapter with header section

## Installation
Add it in your root build.gradle at the end of repositories:
```gradle
allProjects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency:
```gradle
dependencies {
	implementation 'com.github.fajaragungpramana:section-recyclerview:0.0.1'
}
```

## Usage
First step create layout that implement `RecyclerView` component.
```xml
<androidx.recyclerview.widget.RecyclerView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/rv_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" />
```

then create your layout adapter, for example i create `name_adapter.xml`.
```xml
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/tv_name"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="16dp"
    tools:text="Name" />
```

then create data class that must extends class `Section`, for example i create data class named `Name`.
```kotlin
data class Name(
    val id: Int,
    val date: String,
    val listName: List<String>
) : Section(date)
```
on the class `Section` constructor fill with `title` you want in sectin list, in this case i use `date` variable as the title of section list.
</br>
then create class recycler view adapter for your layout adapter, for example i create class named `NameAdapter`.
```kotlin
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
```

then create class recycler view adapter in this case i name `MainAdapter` but you must extends class `SectionRecyclerViewAdapter`, and you must extends class `SectionRecyclerViewHolder` for bind data to adapter and then inflate your custom adapter in the method `bindSectionListAdapter`. In this case i use `NameAdapter`.
```kotlin
class MainAdapter(private val listName: List<Name>) :
    SectionRecyclerViewAdapter<MainAdapter.ViewHolder, Name>(listName) {

    override fun viewHolder(view: View) = ViewHolder(view)

    inner class ViewHolder(view: View) : SectionRecyclerViewHolder(view) {

        override fun bindSectionListAdapter(recyclerView: RecyclerView, position: Int) {
            recyclerView.adapter = NameAdapter(listName[position].listName)
        }

    }

}
```

and in the last step. inflate your main adapter to main recycler view, in this case i use `MainAdapter`. Here is `MainActivity` with data dummy for example
```kotlin
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
```


## License
Copyright 2021 Fajar Agung Pramana

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
