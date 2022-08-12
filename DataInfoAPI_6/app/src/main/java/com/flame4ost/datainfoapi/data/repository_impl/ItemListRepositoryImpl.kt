package com.flame4ost.datainfoapi.data.repository_impl

import com.flame4ost.datainfoapi.data.services.ItemListServices
import com.flame4ost.datainfoapi.domain.models.Item
import com.flame4ost.datainfoapi.domain.repository.ItemListRepository

class ItemListRepositoryImpl(private val itemListServices: ItemListServices) : ItemListRepository {
    override suspend fun getItemList() = itemListServices.getItems()
}