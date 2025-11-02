package ru.pyroman.masik.data.note.list.cache.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pyroman.masik.domain.note.common.model.NoteTag

internal class NoteListTagsCacheRepository {

    private val tags: MutableStateFlow<List<NoteTag>> = MutableStateFlow(emptyList())

    suspend fun setTags(tags: List<NoteTag>) {
        this.tags.emit(tags)
    }

    fun getTags(): StateFlow<List<NoteTag>> {
        return tags
    }
}