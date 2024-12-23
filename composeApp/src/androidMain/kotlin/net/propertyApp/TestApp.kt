package net.propertyApp

import android.app.Application
import net.propertyApp.ui.common.koinInstance
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TestApp)
            modules(koinCommon)
        }.let {
            koinInstance = it.koin
        }
    }
}