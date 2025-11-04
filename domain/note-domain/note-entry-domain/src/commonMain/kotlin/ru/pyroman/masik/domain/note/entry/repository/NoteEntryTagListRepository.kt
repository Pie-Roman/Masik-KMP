package ru.pyroman.masik.domain.note.entry.repository

import ru.pyroman.masik.domain.note.common.model.NoteTag

interface NoteEntryTagListRepository {

    suspend fun getTags(): List<NoteTag>
}