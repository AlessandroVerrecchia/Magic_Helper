package com.alessandro.magichelper

import android.app.Application
import com.alessandro.magichelper.di.appModule
import com.alessandro.scryfallapi.network.di.ScryFallApiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MagicHelperApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MagicHelperApplication)
            modules(
                listOf(appModule, ScryFallApiModule)
            )
        }
    }

}