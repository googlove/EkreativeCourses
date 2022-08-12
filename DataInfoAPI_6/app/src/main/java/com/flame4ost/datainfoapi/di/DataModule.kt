package com.flame4ost.datainfoapi.di

import com.flame4ost.datainfoapi.data.repository_impl.ItemListRepositoryImpl
import com.flame4ost.datainfoapi.data.services.ItemListServices
import com.flame4ost.datainfoapi.domain.repository.ItemListRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val OK_HTTP_TIMEOUT = 40L

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideItemListApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val moshiBuilder = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val moshiConverterFactory = MoshiConverterFactory.create(moshiBuilder)

    return Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(moshiConverterFactory)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
    }.build()
}

fun provideItemListApi(retrofit: Retrofit): ItemListServices = retrofit.create(
    ItemListServices::class.java)

val dataModule = module {
    single<ItemListRepository>{ ItemListRepositoryImpl(get()) }
}