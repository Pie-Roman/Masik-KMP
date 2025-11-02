package ru.pyroman.masik.data.note.list.repository

import ru.pyroman.masik.data.note.list.cache.repository.NoteListTagsCacheRepository
import ru.pyroman.masik.data.note.list.network.repository.NoteListNetworkRepository
import ru.pyroman.masik.domain.note.list.model.NoteList
import ru.pyroman.masik.domain.note.list.repository.NoteListRepository

internal class NoteListRepositoryImpl(
    private val networkRepository: NoteListNetworkRepository,
    private val tagsCacheRepository: NoteListTagsCacheRepository,
) : NoteListRepository {

    override suspend fun launch() {
        return networkRepository.launch()
    }

    override suspend fun getNotes(tagId: String?): NoteList {
        val noteList = networkRepository.getNotes(
            tagId = tagId,
        )
        tagsCacheRepository.setTags(
            tags = noteList.tags
        )

        return noteList
    }
}