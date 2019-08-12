package com.johngachihi.alarmkt

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AlarmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@AlarmApplication)
            modules(appModule)
        }
    }
}