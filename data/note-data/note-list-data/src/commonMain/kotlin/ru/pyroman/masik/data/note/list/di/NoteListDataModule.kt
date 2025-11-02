package ru.pyroman.masik.data.note.list.di

import org.kodein.di.instance
import ru.pyroman.masik.data.note.list.cache.di.noteListCacheDataModule
import ru.pyroman.masik.data.note.list.network.di.noteListNetworkDataModule
import ru.pyroman.masik.data.note.list.repository.NoteListRepositoryImpl
import ru.pyroman.masik.domain.note.list.repository.NoteListRepository
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider

val noteListDataModule = module("noteListDataModule") {

    importAll(
        noteListNetworkDataModule,
        noteListCacheDataModule,
    )

    provider<NoteListRepository> {
        NoteListRepositoryImpl(
            networkRepository = instance(),
            tagsCacheRepository = instance(),
        )
    }
}