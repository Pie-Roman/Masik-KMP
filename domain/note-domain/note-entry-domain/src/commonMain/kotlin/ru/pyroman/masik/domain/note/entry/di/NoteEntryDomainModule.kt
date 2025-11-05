package ru.pyroman.masik.domain.note.entry.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.pyroman.masik.common.mvi.Processor
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryIntent
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryTagListIntent
import ru.pyroman.masik.domain.note.entry.processor.NoteEntryProcessor
import ru.pyroman.masik.domain.note.entry.processor.NoteEntryTagListProcessor

val noteEntryDomainModule = module {

    factory<Processor<NoteEntryIntent>>(named("noteEntryProcessor")) {
        NoteEntryProcessor(
            repository = get(),
        )
    }

    factory<Processor<NoteEntryTagListIntent>>(named("noteEntryTagListProcessor")) {
        NoteEntryTagListProcessor(
            repository = get(),
        )
    }
}