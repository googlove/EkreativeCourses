/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.overview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsrealestate.databinding.GridViewItemBinding
import com.example.android.marsrealestate.network.MarsProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.ClassCastException

private val ITEM_VIEW_TYPE_MARS_PROPERTY = 0

class PhotoGridAdapter() : ListAdapter<DataItem, PhotoGridAdapter.ViewHolder>(DataItemCallback()) {

    val coroutineScope = CoroutineScope(Dispatchers.Default)

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.MarsPropertyItem -> ITEM_VIEW_TYPE_MARS_PROPERTY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            0 -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType ${viewType}")
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val item = getItem(position) as DataItem.MarsPropertyItem
                holder.bind(item.property)
            }
        }
    }

    fun customSubmitList(list1 : List<MarsProperty>?) {
        coroutineScope.launch{
            val items :List<DataItem> = when(list1) {
                null -> listOf()
                else -> list1.map { DataItem.MarsPropertyItem(it)}
            }

            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }


    class ViewHolder(val binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: MarsProperty
        ) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GridViewItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }

        }

    }

}


class DataItemCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

}

sealed class DataItem() {
    abstract val id: String

    class MarsPropertyItem(val property: MarsProperty) : DataItem() {
        override val id = property.id
    }

}

