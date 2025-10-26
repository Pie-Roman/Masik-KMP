package ru.pyroman.masik.domain.note.list.repository

import ru.pyroman.masik.domain.note.list.model.NoteList

interface NoteListRepository {

    suspend fun launch()

    suspend fun getNotes(tagId: String?): NoteList
}