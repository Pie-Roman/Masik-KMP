package ru.pyroman.masik.feature.note.list.di

import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.data.note.list.di.noteListDataModule
import ru.pyroman.masik.domain.note.list.di.noteListDomainModule
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.feature.note.entry.di.noteEntryFeatureModule
import ru.pyroman.masik.feature.note.list.formatter.NoteListFormatter
import ru.pyroman.masik.feature.note.list.reducer.NoteListReducer
import ru.pyroman.masik.feature.note.list.state.NoteListState
import ru.pyroman.masik.feature.note.list.viewmodel.NoteListTabsViewModel
import ru.pyroman.masik.feature.note.list.viewmodel.NoteListViewModel

val noteListFeatureModule = module {

    includes(
        noteListDataModule,
        noteListDomainModule,
        noteEntryFeatureModule,
    )

    factory<NoteListFormatter> {
        NoteListFormatter()
    }

    factory<Reducer<NoteListState, NoteListIntent>>(named("noteListReducer")) {
        NoteListReducer(
            noteListFormatter = get(),
        )
    }

    viewModel<NoteListViewModel> {
        NoteListViewModel(
            processor = get(),
            reducer = get(named("noteListReducer")),
        )
    }

    viewModel<NoteListTabsViewModel> {
        NoteListTabsViewModel(
            repository = get(),
        )
    }
}