package ru.pyroman.masik.domain.note.list.di

import org.kodein.di.instance
import ru.pyroman.masik.common.mvi.Processor
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.domain.note.list.processor.NoteListProcessor
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider

val noteListDomainModule = module("noteListNetworkDataModule") {

    provider<Processor<NoteListIntent>> {
        NoteListProcessor(
            repository = instance(),
        )
    }
}