package ru.pyroman.masik.feature.note.entry.di

import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.data.note.entry.di.noteEntryDataModule
import ru.pyroman.masik.domain.note.entry.di.noteEntryDomainModule
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryIntent
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryTagListIntent
import ru.pyroman.masik.domain.note.entry.model.NoteEntryInitialData
import ru.pyroman.masik.domain.note.entry.model.NoteEntryTagListInitialData
import ru.pyroman.masik.feature.note.entry.reducer.NoteEntryReducer
import ru.pyroman.masik.feature.note.entry.reducer.NoteEntryTagListReducer
import ru.pyroman.masik.feature.note.entry.state.NoteEntryState
import ru.pyroman.masik.feature.note.entry.state.NoteEntryTagListState
import ru.pyroman.masik.feature.note.entry.viewmodel.NoteEntryTagListViewModel
import ru.pyroman.masik.feature.note.entry.viewmodel.NoteEntryViewModel

val noteEntryFeatureModule = module {

    includes(
        noteEntryDataModule,
        noteEntryDomainModule,
    )

    factory<Reducer<NoteEntryState, NoteEntryIntent>>(named("noteEntryReducer")) {
        NoteEntryReducer()
    }

    factory<Reducer<NoteEntryTagListState, NoteEntryTagListIntent>>(named("noteEntryTagListReducer")) {
        NoteEntryTagListReducer()
    }

    viewModel<NoteEntryViewModel> { (initialData: NoteEntryInitialData) ->
        NoteEntryViewModel(
            initialData = initialData,
            processor = get(named("noteEntryProcessor")),
            reducer = get(named("noteEntryReducer")),
        )
    }

    viewModel<NoteEntryTagListViewModel> { (initialData: NoteEntryTagListInitialData) ->
        NoteEntryTagListViewModel(
            initialData = initialData,
            processor = get(named("noteEntryTagListProcessor")),
            reducer = get(named("noteEntryTagListReducer")),
        )
    }
}