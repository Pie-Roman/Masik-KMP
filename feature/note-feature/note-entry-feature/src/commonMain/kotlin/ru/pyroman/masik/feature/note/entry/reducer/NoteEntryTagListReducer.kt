package ru.pyroman.masik.feature.note.entry.reducer

import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryTagListIntent
import ru.pyroman.masik.feature.note.entry.state.NoteEntryTagListState

internal class NoteEntryTagListReducer : Reducer<NoteEntryTagListState, NoteEntryTagListIntent> {

    override fun reduce(
        currentState: NoteEntryTagListState,
        intent: NoteEntryTagListIntent
    ): NoteEntryTagListState {
        return when (intent) {

            is NoteEntryTagListIntent.ShowLoading -> {
                if (currentState is NoteEntryTagListState.Loaded) {
                    NoteEntryTagListState.Loading(
                        tags = currentState.tags
                    )
                } else {
                    NoteEntryTagListState.Loading(
                        tags = emptyList()
                    )
                }
            }

            is NoteEntryTagListIntent.ShowLoaded -> {
                NoteEntryTagListState.Loaded(
                    tags = intent.tags,
                )
            }

            is NoteEntryTagListIntent.ShowAdded -> {
                if (currentState is NoteEntryTagListState.Loading) {
                    val tags = currentState.tags + intent.tag
                    NoteEntryTagListState.Loaded(
                        tags = tags,
                    )
                } else {
                    currentState
                }
            }

            is NoteEntryTagListIntent.ShowUpdated -> {
                if (currentState is NoteEntryTagListState.Loading) {
                    val tags = currentState.tags.map { tag ->
                        if (tag.id == intent.tag.id) {
                            intent.tag
                        } else {
                            tag
                        }
                    }
                    NoteEntryTagListState.Loaded(
                        tags = tags,
                    )
                } else {
                    currentState
                }
            }

            else -> return currentState
        }
    }
}