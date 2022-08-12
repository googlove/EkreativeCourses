package com.flame4ost.datainfoapi.di

import com.flame4ost.datainfoapi.presentation.view_model.ListItemsActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListItemsActivityViewModel(get()) }
}