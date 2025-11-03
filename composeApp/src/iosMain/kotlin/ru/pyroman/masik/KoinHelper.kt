package ru.pyroman.masik

import org.koin.core.context.startKoin
import ru.pyroman.masik.di.appModule

fun initKoin(){
    startKoin {
        modules(appModule)
    }
}