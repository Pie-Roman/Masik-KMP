package ru.pyroman.masik.feature.note.list.di

import org.koin.dsl.module
import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.data.note.list.di.noteListDataModule
import ru.pyroman.masik.domain.note.list.di.noteListDomainModule
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.feature.note.list.formatter.NoteListFormatter
import ru.pyroman.masik.feature.note.list.reducer.NoteListReducer
import ru.pyroman.masik.feature.note.list.state.NoteListState
import ru.pyroman.masik.feature.note.list.viewmodel.NoteListViewModel

val noteListFeatureModule = module {

    includes(
        noteListDataModule,
        noteListDomainModule,
    )

    factory<NoteListFormatter> {
        NoteListFormatter()
    }

    factory<Reducer<NoteListState, NoteListIntent>> {
        NoteListReducer(
            noteListFormatter = get(),
        )
    }

    factory<NoteListViewModel> {
        NoteListViewModel(
            processor = get(),
            reducer = get(),
        )
    }
}