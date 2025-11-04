package ru.pyroman.masik.data.note.entry.network.repository

import ru.pyroman.masik.data.note.common.network.mapper.NoteBodyNetworkMapper
import ru.pyroman.masik.data.note.common.network.mapper.NoteNetworkMapper
import ru.pyroman.masik.data.note.entry.network.datasource.NoteEntryNetworkDataSource
import ru.pyroman.masik.domain.note.common.model.Note
import ru.pyroman.masik.domain.note.common.model.NoteBody

internal class NoteEntryNetworkRepository(
    private val dataSource: NoteEntryNetworkDataSource,
    private val noteNetworkMapper: NoteNetworkMapper,
    private val noteBodyNetworkMapper: NoteBodyNetworkMapper,
) {

    suspend fun add(noteBody: NoteBody): Note {
        val noteBodyNetworkDto = noteBodyNetworkMapper.map(noteBody)
        val noteNetworkDto = dataSource.add(noteBodyNetworkDto)
        return noteNetworkMapper.map(noteNetworkDto)
    }

    suspend fun update(
        id: String,
        noteBody: NoteBody,
    ): Note {
        val noteBodyNetworkDto = noteBodyNetworkMapper.map(noteBody)
        val noteNetworkDto = dataSource.update(id, noteBodyNetworkDto)
        return noteNetworkMapper.map(noteNetworkDto)
    }
}