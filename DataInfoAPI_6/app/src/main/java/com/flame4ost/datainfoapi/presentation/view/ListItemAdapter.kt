package com.flame4ost.datainfoapi.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flame4ost.datainfoapi.R
import com.flame4ost.datainfoapi.databinding.RecyclerViewItemBinding
import com.flame4ost.datainfoapi.domain.models.Item

class ListItemAdapter : ListAdapter<Item, ListItemAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(inflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

        class ItemViewHolder(private val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            with(binding) {
                Glide.with(imgItem.context)
                    .load("${item.url}.png")
                    .error(R.drawable.ic_not_image)
                    .circleCrop()
                    .into(imgItem)

                titleItem.text = item.title
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}
