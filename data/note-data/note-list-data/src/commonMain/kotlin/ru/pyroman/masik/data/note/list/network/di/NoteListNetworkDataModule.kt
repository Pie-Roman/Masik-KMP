package ru.pyroman.masik.data.note.list.network.di

import org.kodein.di.instance
import ru.pyroman.masik.data.common.di.commonDataModule
import ru.pyroman.masik.data.note.common.network.di.noteCommonDataModule
import ru.pyroman.masik.data.note.list.network.api.NoteListNetworkClient
import ru.pyroman.masik.data.note.list.network.datasource.NoteListNetworkDataSource
import ru.pyroman.masik.data.note.list.network.mapper.NoteListNetworkMapper
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider

val noteListNetworkDataModule = module("noteListNetworkDataModule") {

    importAll(
        noteCommonDataModule,
        commonDataModule,
    )

    provider<NoteListNetworkClient> {
        NoteListNetworkClient(
            httpClient = instance(),
        )
    }

    provider<NoteListNetworkDataSource> {
        NoteListNetworkDataSource(
            client = instance(),
        )
    }

    provider<NoteListNetworkMapper> {
        NoteListNetworkMapper(
            noteNetworkMapper = instance(),
            noteTagNetworkMapper = instance(),
        )
    }
}