package ru.pyroman.masik.data.common.di

import org.kodein.di.instance
import ru.pyroman.masik.data.common.network.MasikHttpClient
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.singleton

val commonDataModule = module("commonDataModule") {

    singleton {
        MasikHttpClient(
            httpClient = instance(),
        )
    }
}