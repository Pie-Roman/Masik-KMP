package ru.pyroman.masik.feature.note.list.di

import org.kodein.di.instance
import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.data.note.list.di.noteListDataModule
import ru.pyroman.masik.domain.note.list.di.noteListDomainModule
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.feature.note.list.formatter.NoteListFormatter
import ru.pyroman.masik.feature.note.list.reducer.NoteListReducer
import ru.pyroman.masik.feature.note.list.state.NoteListState
import ru.pyroman.masik.feature.note.list.viewmodel.NoteListViewModel
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider

val noteListFeatureModule = module("noteListFeatureModule") {

    importAll(
        noteListDataModule,
        noteListDomainModule,
    )

    provider<NoteListFormatter> {
        NoteListFormatter()
    }

    provider<Reducer<NoteListState, NoteListIntent>> {
        NoteListReducer(
            noteListFormatter = instance(),
        )
    }

    provider<NoteListViewModel> {
        NoteListViewModel(
            processor = instance(),
            reducer = instance(),
        )
    }
}