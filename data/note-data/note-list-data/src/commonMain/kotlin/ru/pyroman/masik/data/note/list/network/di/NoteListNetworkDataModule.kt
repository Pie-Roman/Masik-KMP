package ru.pyroman.masik.data.note.list.network.di

import org.koin.dsl.module
import ru.pyroman.masik.data.common.di.commonDataModule
import ru.pyroman.masik.data.note.common.network.di.noteCommonDataModule
import ru.pyroman.masik.data.note.list.network.api.NoteListNetworkClient
import ru.pyroman.masik.data.note.list.network.datasource.NoteListNetworkDataSource
import ru.pyroman.masik.data.note.list.network.mapper.NoteListNetworkMapper

val noteListNetworkDataModule = module {

    includes(
        noteCommonDataModule,
        commonDataModule,
    )

    factory<NoteListNetworkClient> {
        NoteListNetworkClient(
            httpClient = get(),
        )
    }

    factory<NoteListNetworkDataSource> {
        NoteListNetworkDataSource(
            client = get(),
        )
    }

    factory<NoteListNetworkMapper> {
        NoteListNetworkMapper(
            noteNetworkMapper = get(),
            noteTagNetworkMapper = get(),
        )
    }
}