package ru.pyroman.masik.data.note.entry.network.di

import org.koin.dsl.module
import ru.pyroman.masik.data.common.di.commonDataModule
import ru.pyroman.masik.data.note.common.network.di.noteCommonDataModule
import ru.pyroman.masik.data.note.entry.network.api.NoteEntryNetworkClient
import ru.pyroman.masik.data.note.entry.network.datasource.NoteEntryNetworkDataSource
import ru.pyroman.masik.data.note.entry.network.datasource.NoteEntryTagListNetworkDataSource
import ru.pyroman.masik.data.note.entry.network.repository.NoteEntryNetworkRepository
import ru.pyroman.masik.data.note.entry.network.repository.NoteEntryTagListNetworkRepository

val noteEntryNetworkDataModule = module {

    includes(
        noteCommonDataModule,
        commonDataModule,
    )

    factory<NoteEntryNetworkClient> {
        NoteEntryNetworkClient(
            httpClient = get(),
        )
    }

    factory<NoteEntryNetworkDataSource> {
        NoteEntryNetworkDataSource(
            client = get(),
        )
    }

    factory<NoteEntryTagListNetworkDataSource> {
        NoteEntryTagListNetworkDataSource(
            client = get(),
        )
    }

    factory<NoteEntryNetworkRepository> {
        NoteEntryNetworkRepository(
            dataSource = get(),
            noteNetworkMapper = get(),
            noteBodyNetworkMapper = get(),
        )
    }

    factory<NoteEntryTagListNetworkRepository> {
        NoteEntryTagListNetworkRepository(
            dataSource = get(),
            noteTagNetworkMapper = get(),
        )
    }
}