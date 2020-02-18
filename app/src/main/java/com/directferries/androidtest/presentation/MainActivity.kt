package com.directferries.androidtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.directferries.androidtest.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view_car.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MainViewModel by viewModels()

        cars_recycler.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter
        cars_recycler.adapter = adapter
        adapter.listItems = model.getCars().value?.toMutableList() ?: mutableListOf()
    }

    object Adapter : RecyclerView.Adapter<Holder>() {
        var listItems: MutableList<CarEntity> = mutableListOf()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(View.inflate(parent.context, R.layout.item_view_car, parent))
        }

        override fun getItemCount(): Int {
            return listItems.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.bindView(listItems[position])
        }
    }

    class Holder(view: View): RecyclerView.ViewHolder(view) {
        fun bindView(car: CarEntity) {
            itemView.make.text = car.make
            itemView.model.text = car.model
        }
    }
}
