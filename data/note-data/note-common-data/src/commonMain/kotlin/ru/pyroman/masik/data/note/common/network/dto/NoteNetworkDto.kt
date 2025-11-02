package ru.pyroman.masik.data.note.common.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NoteNetworkDto(
    @SerialName("id") val id: String?,
    @SerialName("body") val body: NoteBodyNetworkDto?,
)