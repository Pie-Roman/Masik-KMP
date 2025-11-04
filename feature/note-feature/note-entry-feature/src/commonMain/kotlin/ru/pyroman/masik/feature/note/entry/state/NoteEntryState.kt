package ru.pyroman.masik.feature.note.entry.state

import ru.pyroman.masik.domain.note.common.model.Note

sealed interface NoteEntryState {

    data object Idle : NoteEntryState

    data class Added(
        val note: Note
    ) : NoteEntryState

    data class Updated(
        val note: Note
    ) : NoteEntryState
}
