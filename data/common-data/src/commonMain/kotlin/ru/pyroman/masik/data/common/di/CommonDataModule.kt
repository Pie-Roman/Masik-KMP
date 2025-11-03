package ru.pyroman.masik.data.common.di

import org.koin.dsl.module
import ru.pyroman.masik.data.common.network.MasikHttpClient

val commonDataModule = module {

    single {
        MasikHttpClient(
            httpClient = get(),
        )
    }
}