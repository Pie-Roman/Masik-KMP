package ru.pyroman.masik.data.note.list.repository

import kotlinx.coroutines.flow.StateFlow
import ru.pyroman.masik.data.note.list.cache.repository.NoteListTagsCacheRepository
import ru.pyroman.masik.domain.note.common.model.NoteTag
import ru.pyroman.masik.domain.note.list.repository.NoteListTagsRepository

internal class NoteListTagsRepositoryImpl(
    private val cacheRepository: NoteListTagsCacheRepository,
) : NoteListTagsRepository {

    override fun getTags(): StateFlow<List<NoteTag>> {
        return cacheRepository.getTags()
    }
}