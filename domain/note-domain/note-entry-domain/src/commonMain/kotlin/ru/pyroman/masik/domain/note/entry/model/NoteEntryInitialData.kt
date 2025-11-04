package ru.pyroman.masik.domain.note.entry.model

import ru.pyroman.masik.domain.note.common.model.Note

data class NoteEntryInitialData(
    val mode: NoteEntryMode,
    val note: Note? = null,
)