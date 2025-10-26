package ru.pyroman.masik.domain.note.list.model

import ru.pyroman.masik.domain.note.common.model.Note
import ru.pyroman.masik.domain.note.common.model.NoteTag

data class NoteList(
    val tags: List<NoteTag>,
    val items: List<Note>,
)