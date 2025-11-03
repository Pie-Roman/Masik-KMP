package ru.pyroman.masik.domain.note.list.di

import org.koin.dsl.module
import ru.pyroman.masik.common.mvi.Processor
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.domain.note.list.processor.NoteListProcessor

val noteListDomainModule = module {

    factory<Processor<NoteListIntent>> {
        NoteListProcessor(
            repository = get(),
        )
    }
}