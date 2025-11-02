package ru.pyroman.masik.data.note.common.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NoteTagNetworkDto(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String?,
    @SerialName("color") val color: String?,
)