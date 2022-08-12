package com.flame4ost.datainfoapi.domain.usecase

import com.flame4ost.datainfoapi.domain.repository.ItemListRepository

class LoadListItemUseCase(private val moviesListRepository: ItemListRepository) {

    suspend fun loadItemList() = moviesListRepository.getItemList()
}
