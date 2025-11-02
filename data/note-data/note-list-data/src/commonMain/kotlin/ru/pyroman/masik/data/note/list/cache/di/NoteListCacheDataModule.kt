package ru.pyroman.masik.data.note.list.cache.di

import ru.pyroman.masik.data.note.list.cache.repository.NoteListTagsCacheRepository
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.singleton

val noteListCacheDataModule = module("noteListCacheDataModule") {

    singleton<NoteListTagsCacheRepository> {
        NoteListTagsCacheRepository()
    }
}