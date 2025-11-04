package ru.pyroman.masik.data.note.entry.network.datasource

import ru.pyroman.masik.data.note.common.network.dto.NoteTagNetworkDto
import ru.pyroman.masik.data.note.entry.network.api.NoteEntryNetworkClient

internal class NoteEntryTagListNetworkDataSource(
    private val client: NoteEntryNetworkClient,
) {

    suspend fun getTags(): List<NoteTagNetworkDto> {
        return client.getTags()
    }
}