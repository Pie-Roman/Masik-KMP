package ru.pyroman.masik.data.note.common.network.di

import org.kodein.di.instance
import ru.pyroman.masik.data.note.common.network.mapper.NoteBodyNetworkMapper
import ru.pyroman.masik.data.note.common.network.mapper.NoteNetworkMapper
import ru.pyroman.masik.data.note.common.network.mapper.NoteTagNetworkMapper
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider

val noteCommonDataModule = module("noteCommonDataModule") {

    provider<NoteTagNetworkMapper> {
        NoteTagNetworkMapper()
    }

    provider<NoteBodyNetworkMapper> {
        NoteBodyNetworkMapper(
            noteTagNetworkMapper = instance(),
        )
    }

    provider<NoteNetworkMapper> {
        NoteNetworkMapper(
            noteBodyNetworkMapper = instance(),
        )
    }
}