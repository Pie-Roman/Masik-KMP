package ru.pyroman.masik.domain.note.common.model

data class NoteBody(
    val title: String,
    val isDone: Boolean,
    val tags: List<NoteTag>,
)