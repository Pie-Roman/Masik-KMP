package ru.pyroman.masik.data.note.entry.repository

import ru.pyroman.masik.data.note.entry.network.repository.NoteEntryNetworkRepository
import ru.pyroman.masik.domain.note.common.model.Note
import ru.pyroman.masik.domain.note.common.model.NoteBody
import ru.pyroman.masik.domain.note.entry.repository.NoteEntryRepository

internal class NoteEntryRepositoryImpl(
    private val networkRepository: NoteEntryNetworkRepository,
) : NoteEntryRepository {

    override suspend fun add(noteBody: NoteBody): Note {
        return networkRepository.add(noteBody)
    }

    override suspend fun update(
        id: String,
        noteBody: NoteBody
    ): Note {
        return networkRepository.update(id, noteBody)
    }
}