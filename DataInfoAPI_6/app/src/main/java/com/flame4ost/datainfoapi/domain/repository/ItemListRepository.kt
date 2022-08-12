package com.flame4ost.datainfoapi.domain.repository

import com.flame4ost.datainfoapi.domain.models.Item

interface ItemListRepository {
    suspend fun getItemList(): List<Item>
}