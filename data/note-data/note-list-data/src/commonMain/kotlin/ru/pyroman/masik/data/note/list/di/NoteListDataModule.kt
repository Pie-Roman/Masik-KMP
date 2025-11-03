package ru.pyroman.masik.data.note.list.di

import org.koin.dsl.module
import ru.pyroman.masik.data.note.list.cache.di.noteListCacheDataModule
import ru.pyroman.masik.data.note.list.network.di.noteListNetworkDataModule
import ru.pyroman.masik.data.note.list.repository.NoteListRepositoryImpl
import ru.pyroman.masik.domain.note.list.repository.NoteListRepository

val noteListDataModule = module {

    includes(
        noteListNetworkDataModule,
        noteListCacheDataModule,
    )

    factory<NoteListRepository> {
        NoteListRepositoryImpl(
            networkRepository = get(),
            tagsCacheRepository = get(),
        )
    }
}