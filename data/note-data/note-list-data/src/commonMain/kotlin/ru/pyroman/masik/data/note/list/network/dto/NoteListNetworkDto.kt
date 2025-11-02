package ru.pyroman.masik.data.note.list.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.pyroman.masik.data.note.common.network.dto.NoteNetworkDto
import ru.pyroman.masik.data.note.common.network.dto.NoteTagNetworkDto

@Serializable
internal data class NoteListNetworkDto(
    @SerialName("tags") val tags: List<NoteTagNetworkDto>?,
    @SerialName("items") val items: List<NoteNetworkDto>?,
)