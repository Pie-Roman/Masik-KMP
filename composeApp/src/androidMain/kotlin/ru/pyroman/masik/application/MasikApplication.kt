package ru.pyroman.masik.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.pyroman.masik.di.appModule

class MasikApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MasikApplication)
            modules(appModule)
        }
    }
}