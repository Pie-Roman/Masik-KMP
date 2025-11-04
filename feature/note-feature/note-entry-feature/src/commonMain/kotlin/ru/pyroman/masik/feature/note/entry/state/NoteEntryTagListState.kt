package ru.pyroman.masik.feature.note.entry.state

import ru.pyroman.masik.domain.note.common.model.NoteTag

sealed interface NoteEntryTagListState {

    data object Idle : NoteEntryTagListState

    data class Loading(
        val tags: List<NoteTag>
    ) : NoteEntryTagListState

    data class Loaded(
        val tags: List<NoteTag>
    ) : NoteEntryTagListState
}