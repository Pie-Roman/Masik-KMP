package ru.pyroman.masik.data.note.common.network.mapper

import ru.pyroman.masik.data.note.common.network.dto.NoteBodyNetworkDto
import ru.pyroman.masik.domain.note.common.model.NoteBody

class NoteBodyNetworkMapper(
    private val noteTagNetworkMapper: NoteTagNetworkMapper,
) {

    fun map(dto: NoteBodyNetworkDto): NoteBody {
        val title = dto.title.orEmpty()
        val isDone = dto.isDone ?: false
        val tags = dto.tags.orEmpty().map { tagDto ->
            noteTagNetworkMapper.map(tagDto)
        }

        return NoteBody(
            title = title,
            isDone = isDone,
            tags = tags,
        )
    }

    fun map(model: NoteBody): NoteBodyNetworkDto {
        val title = model.title
        val isDone = model.isDone
        val tags = model.tags.map { tag ->
            noteTagNetworkMapper.map(tag)
        }

        return NoteBodyNetworkDto(
            title = title,
            isDone = isDone,
            tags = tags,
        )
    }
}