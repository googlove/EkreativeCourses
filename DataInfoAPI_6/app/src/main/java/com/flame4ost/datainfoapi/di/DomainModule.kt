package com.flame4ost.datainfoapi.di

import com.flame4ost.datainfoapi.domain.usecase.LoadListItemUseCase
import org.koin.dsl.module

val domainModule = module {
    factory{ LoadListItemUseCase(get()) }
}