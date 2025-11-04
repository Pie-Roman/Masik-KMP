package ru.pyroman.masik.data.note.entry.repository

import ru.pyroman.masik.data.note.entry.network.repository.NoteEntryTagListNetworkRepository
import ru.pyroman.masik.domain.note.common.model.NoteTag
import ru.pyroman.masik.domain.note.entry.repository.NoteEntryTagListRepository

internal class NoteEntryTagListRepositoryImpl(
    private val networkRepository: NoteEntryTagListNetworkRepository,
) : NoteEntryTagListRepository {

    override suspend fun getTags(): List<NoteTag> {
        return networkRepository.getTags()
    }
}