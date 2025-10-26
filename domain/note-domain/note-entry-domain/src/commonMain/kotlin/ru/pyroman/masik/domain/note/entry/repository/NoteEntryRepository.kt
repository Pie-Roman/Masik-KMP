package ru.pyroman.masik.domain.note.entry.repository

import ru.pyroman.masik.domain.note.common.model.Note
import ru.pyroman.masik.domain.note.common.model.NoteBody

interface NoteEntryRepository {

    suspend fun add(noteBody: NoteBody): Note

    suspend fun update(id: String, noteBody: NoteBody): Note
}