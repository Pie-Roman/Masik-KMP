package ru.pyroman.masik.domain.note.list.repository

import kotlinx.coroutines.flow.StateFlow
import ru.pyroman.masik.domain.note.common.model.NoteTag

interface NoteListTagsRepository {

    fun getTags(): StateFlow<List<NoteTag>>
}