package com.directferries.androidtest.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.directferries.androidtest.data.CarEntity
import com.directferries.androidtest.databinding.ItemViewCarBinding
import kotlinx.android.synthetic.main.item_view_car.view.*

class CarsAdapter : ListAdapter<CarEntity, RecyclerView.ViewHolder>(CarEntityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CarEntityViewHolder(
            ItemViewCarBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val car = getItem(position)
        (holder as CarEntityViewHolder).bind(car)
    }

    class CarEntityViewHolder(
        private val binding: ItemViewCarBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
        }

        fun bind(item: CarEntity) {
            binding.apply {
                car = item
                executePendingBindings()
            }
        }
    }
}

private class CarEntityDiffCallback : DiffUtil.ItemCallback<CarEntity>() {

    override fun areItemsTheSame(oldItem: CarEntity, newItem: CarEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CarEntity, newItem: CarEntity): Boolean {
        return oldItem == newItem
    }
}