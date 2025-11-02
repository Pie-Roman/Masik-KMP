package ru.pyroman.masik.data.note.list.network.repository

import ru.pyroman.masik.data.note.list.network.datasource.NoteListNetworkDataSource
import ru.pyroman.masik.data.note.list.network.dto.NoteListLaunchNetworkDto
import ru.pyroman.masik.data.note.list.network.mapper.NoteListNetworkMapper
import ru.pyroman.masik.domain.note.list.model.NoteList

internal class NoteListNetworkRepository(
    private val mapper: NoteListNetworkMapper,
    private val dataSource: NoteListNetworkDataSource,
) {

    suspend fun launch() {
        val data = NoteListLaunchNetworkDto(
            systemNotes = emptyList(),
        )
        return dataSource.launch(
            data = data,
        )
    }

    suspend fun getNotes(tagId: String?): NoteList {
        val noteListDto = dataSource.getNotes(
            tagId = tagId,
        )
        return mapper.map(noteListDto)
    }
}