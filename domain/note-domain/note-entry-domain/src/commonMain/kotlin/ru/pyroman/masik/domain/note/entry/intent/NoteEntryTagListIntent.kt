package ru.pyroman.masik.domain.note.entry.intent

import ru.pyroman.masik.domain.note.common.model.NoteTag

sealed interface NoteEntryTagListIntent {

    data object Load : NoteEntryTagListIntent

    data object ShowLoading : NoteEntryTagListIntent

    data class ShowLoaded(
        val tags: List<NoteTag>,
    ) : NoteEntryTagListIntent

    data class ShowAdded(
        val tag: NoteTag,
    ) : NoteEntryTagListIntent

    data class ShowUpdated(
        val tag: NoteTag,
    ) : NoteEntryTagListIntent
}