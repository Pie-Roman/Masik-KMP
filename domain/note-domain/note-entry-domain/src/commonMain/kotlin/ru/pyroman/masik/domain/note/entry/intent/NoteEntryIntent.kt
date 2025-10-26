package ru.pyroman.masik.domain.note.entry.intent

import ru.pyroman.masik.domain.note.common.model.Note
import ru.pyroman.masik.domain.note.common.model.NoteBody

sealed interface NoteEntryIntent {

    data class Add(
        val body: NoteBody,
    ) : NoteEntryIntent

    data class ShowAdded(
        val note: Note,
    ) : NoteEntryIntent

    data class Update(
        val id: String,
        val body: NoteBody,
    ) : NoteEntryIntent

    data class ShowUpdated(
        val note: Note,
    ) : NoteEntryIntent
}