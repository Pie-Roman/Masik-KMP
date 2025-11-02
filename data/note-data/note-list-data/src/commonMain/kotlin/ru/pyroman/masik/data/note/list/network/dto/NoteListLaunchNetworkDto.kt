package ru.pyroman.masik.data.note.list.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.pyroman.masik.data.note.common.network.dto.NoteNetworkDto

@Serializable
internal data class NoteListLaunchNetworkDto(
    @SerialName("systemNotes") val systemNotes: List<NoteNetworkDto>?,
)