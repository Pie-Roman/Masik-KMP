package ru.pyroman.masik.data.note.common.network.mapper

import ru.pyroman.masik.data.note.common.network.dto.NoteTagNetworkDto
import ru.pyroman.masik.domain.note.common.model.NoteTag

class NoteTagNetworkMapper {

    fun map(dto: NoteTagNetworkDto): NoteTag {
        val id = requireNotNull(dto.id)
        val name = requireNotNull(dto.name)
        val color = requireNotNull(dto.color)

        return NoteTag(
            id = id,
            name = name,
            color = color,
        )
    }
}