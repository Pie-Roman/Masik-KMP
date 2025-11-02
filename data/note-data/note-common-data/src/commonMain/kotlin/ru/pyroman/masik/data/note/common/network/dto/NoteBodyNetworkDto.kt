package ru.pyroman.masik.data.note.common.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NoteBodyNetworkDto(
    @SerialName("title") val title: String?,
    @SerialName("isDone") val isDone: Boolean?,
    @SerialName("tags") val tags: List<NoteTagNetworkDto>?,
)