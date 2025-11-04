package ru.pyroman.masik.data.note.entry.di

import org.koin.dsl.module
import ru.pyroman.masik.data.note.entry.network.di.noteEntryNetworkDataModule
import ru.pyroman.masik.data.note.entry.repository.NoteEntryRepositoryImpl
import ru.pyroman.masik.data.note.entry.repository.NoteEntryTagListRepositoryImpl
import ru.pyroman.masik.domain.note.entry.repository.NoteEntryRepository
import ru.pyroman.masik.domain.note.entry.repository.NoteEntryTagListRepository

val noteEntryDataModule = module {

    includes(
        noteEntryNetworkDataModule
    )

    factory<NoteEntryRepository> {
        NoteEntryRepositoryImpl(
            networkRepository = get(),
        )
    }

    factory<NoteEntryTagListRepository> {
        NoteEntryTagListRepositoryImpl(
            networkRepository = get(),
        )
    }
}