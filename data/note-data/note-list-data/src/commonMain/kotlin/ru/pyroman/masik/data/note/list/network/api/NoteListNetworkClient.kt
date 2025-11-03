package ru.pyroman.masik.data.note.list.network.api

import io.ktor.client.call.body
import ru.pyroman.masik.data.common.network.MasikHttpClient
import ru.pyroman.masik.data.note.list.network.dto.NoteListLaunchNetworkDto
import ru.pyroman.masik.data.note.list.network.dto.NoteListNetworkDto

internal class NoteListNetworkClient(
    private val httpClient: MasikHttpClient,
) {

    suspend fun launch(data: NoteListLaunchNetworkDto) {
        httpClient.post(
            path = "/notes/launch",
            requestBody = data,
        )
    }

    suspend fun getNotes(tagId: String?): NoteListNetworkDto {
        return httpClient.get(
            path = "/notes",
            params = buildMap {
                if (tagId != null) {
                    put("tagId", tagId)
                }
            }
        ).body()
    }
}