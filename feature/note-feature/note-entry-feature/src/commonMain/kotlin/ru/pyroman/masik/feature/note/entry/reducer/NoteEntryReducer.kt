package ru.pyroman.masik.feature.note.entry.reducer

import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryIntent
import ru.pyroman.masik.feature.note.entry.state.NoteEntryState

class NoteEntryReducer : Reducer<NoteEntryState, NoteEntryIntent> {

    override fun reduce(currentState: NoteEntryState, intent: NoteEntryIntent): NoteEntryState {
        return when (intent) {

            is NoteEntryIntent.ShowAdded -> NoteEntryState.Added(
                note = intent.note,
            )

            is NoteEntryIntent.ShowUpdated -> NoteEntryState.Updated(
                note = intent.note,
            )

            else -> currentState
        }
    }
}