package ru.pyroman.masik.data.note.entry.network.datasource

import ru.pyroman.masik.data.note.common.network.dto.NoteBodyNetworkDto
import ru.pyroman.masik.data.note.common.network.dto.NoteNetworkDto
import ru.pyroman.masik.data.note.entry.network.api.NoteEntryNetworkClient

internal class NoteEntryNetworkDataSource(
    private val client: NoteEntryNetworkClient,
) {

    suspend fun add(noteBody: NoteBodyNetworkDto): NoteNetworkDto {
        return client.add(noteBody)
    }

    suspend fun update(
        id: String,
        noteBody: NoteBodyNetworkDto
    ): NoteNetworkDto {
        return client.update(id, noteBody)
    }
}