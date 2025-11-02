package ru.pyroman.masik.data.note.list.network.api

import io.ktor.client.call.body
import io.ktor.http.URLBuilder
import io.ktor.http.appendPathSegments
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
            path = URLBuilder().apply {
                appendPathSegments("notes")
                if (tagId != null) {
                    parameters.append("tagId", tagId)
                }
            }.buildString()
        ).body()
    }
}