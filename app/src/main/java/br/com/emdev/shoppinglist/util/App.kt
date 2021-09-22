package br.com.emdev.shoppinglist.util

import android.app.Application
import br.com.emdev.shoppinglist.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                )
            )
        }

    }
}