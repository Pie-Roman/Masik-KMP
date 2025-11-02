package ru.pyroman.masik.data.note.list.network.datasource

import ru.pyroman.masik.data.note.list.network.api.NoteListNetworkClient
import ru.pyroman.masik.data.note.list.network.dto.NoteListLaunchNetworkDto
import ru.pyroman.masik.data.note.list.network.dto.NoteListNetworkDto

internal class NoteListNetworkDataSource(
    private val client: NoteListNetworkClient,
) {

    suspend fun launch(data: NoteListLaunchNetworkDto) {
        return client.launch(
            data = data,
        )
    }

    suspend fun getNotes(tagId: String?): NoteListNetworkDto {
        return client.getNotes(
            tagId = tagId,
        )
    }
}