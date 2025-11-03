package ru.pyroman.masik.data.note.common.network.di

import org.koin.dsl.module
import ru.pyroman.masik.common.core.network.ktor.networkModule
import ru.pyroman.masik.data.note.common.network.mapper.NoteBodyNetworkMapper
import ru.pyroman.masik.data.note.common.network.mapper.NoteNetworkMapper
import ru.pyroman.masik.data.note.common.network.mapper.NoteTagNetworkMapper

val noteCommonDataModule = module {

    includes(
        networkModule
    )

    factory<NoteTagNetworkMapper> {
        NoteTagNetworkMapper()
    }

    factory<NoteBodyNetworkMapper> {
        NoteBodyNetworkMapper(
            noteTagNetworkMapper = get(),
        )
    }

    factory<NoteNetworkMapper> {
        NoteNetworkMapper(
            noteBodyNetworkMapper = get(),
        )
    }
}