package ru.pyroman.masik.data.note.common.network.mapper

import ru.pyroman.masik.data.note.common.network.dto.NoteNetworkDto
import ru.pyroman.masik.domain.note.common.model.Note

class NoteNetworkMapper(
    private val noteBodyNetworkMapper: NoteBodyNetworkMapper,
) {

    fun map(dto: NoteNetworkDto): Note {
        val id = requireNotNull(dto.id)
        val body = requireNotNull(dto.body?.let { bodyDto ->
            noteBodyNetworkMapper.map(bodyDto)
        })

        return Note(
            id = id,
            body = body,
        )
    }
}