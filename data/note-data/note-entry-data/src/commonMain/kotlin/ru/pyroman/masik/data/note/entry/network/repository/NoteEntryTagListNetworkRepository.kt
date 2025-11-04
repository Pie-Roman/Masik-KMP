package ru.pyroman.masik.data.note.entry.network.repository

import ru.pyroman.masik.data.note.common.network.mapper.NoteTagNetworkMapper
import ru.pyroman.masik.data.note.entry.network.datasource.NoteEntryTagListNetworkDataSource
import ru.pyroman.masik.domain.note.common.model.NoteTag

internal class NoteEntryTagListNetworkRepository(
    private val dataSource: NoteEntryTagListNetworkDataSource,
    private val noteTagNetworkMapper: NoteTagNetworkMapper,
) {

    suspend fun getTags(): List<NoteTag> {
        val tagsDto = dataSource.getTags()
        return tagsDto.map { tagDto ->
            noteTagNetworkMapper.map(tagDto)
        }
    }
}