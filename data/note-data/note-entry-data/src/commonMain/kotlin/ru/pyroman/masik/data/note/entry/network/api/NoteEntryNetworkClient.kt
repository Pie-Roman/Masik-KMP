package ru.pyroman.masik.data.note.entry.network.api

import io.ktor.client.call.body
import ru.pyroman.masik.data.common.network.MasikHttpClient
import ru.pyroman.masik.data.note.common.network.dto.NoteBodyNetworkDto
import ru.pyroman.masik.data.note.common.network.dto.NoteNetworkDto
import ru.pyroman.masik.data.note.common.network.dto.NoteTagNetworkDto

internal class NoteEntryNetworkClient(
    private val httpClient: MasikHttpClient,
) {

    suspend fun add(data: NoteBodyNetworkDto): NoteNetworkDto {
        return httpClient.post(
            path = "/notes",
            requestBody = data,
        ).body()
    }

    suspend fun update(
        id: String,
        data: NoteBodyNetworkDto
    ): NoteNetworkDto {
        return httpClient.patch(
            path = "/notes/$id",
            requestBody = data,
        ).body()
    }

    suspend fun getTags(): List<NoteTagNetworkDto> {
        return httpClient.get(
            path = "/notes/tags"
        ).body()
    }
}