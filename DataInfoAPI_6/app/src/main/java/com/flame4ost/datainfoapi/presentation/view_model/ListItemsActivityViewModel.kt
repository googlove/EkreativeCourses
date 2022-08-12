package com.flame4ost.datainfoapi.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flame4ost.datainfoapi.domain.models.Item
import com.flame4ost.datainfoapi.domain.usecase.LoadListItemUseCase
import kotlinx.coroutines.launch

class ListItemsActivityViewModel(private val loadListItemUseCase: LoadListItemUseCase) :
    ViewModel() {
    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    fun loadItemList() {
        viewModelScope.launch {
            _itemList.value = loadListItemUseCase.loadItemList()
        }
    }
}