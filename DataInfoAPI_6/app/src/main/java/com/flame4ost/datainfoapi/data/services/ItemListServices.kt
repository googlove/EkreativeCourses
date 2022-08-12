package com.flame4ost.datainfoapi.data.services

import com.flame4ost.datainfoapi.domain.models.Item
import retrofit2.http.GET

interface ItemListServices {
    @GET("/photos")
    suspend fun getItems(): List<Item>
}