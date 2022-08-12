package com.flame4ost.datainfoapi.app

import android.app.Application
import com.flame4ost.datainfoapi.di.appModule
import com.flame4ost.datainfoapi.di.dataModule
import com.flame4ost.datainfoapi.di.domainModule
import com.flame4ost.datainfoapi.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(
                networkModule,
                dataModule,
                appModule,
                domainModule,
            ))
        }
    }
}