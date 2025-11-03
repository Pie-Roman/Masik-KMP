package ru.pyroman.masik.data.note.list.cache.di

import org.koin.dsl.module
import ru.pyroman.masik.data.note.list.cache.repository.NoteListTagsCacheRepository

val noteListCacheDataModule = module {

    single<NoteListTagsCacheRepository> {
        NoteListTagsCacheRepository()
    }
}