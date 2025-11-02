package ru.pyroman.masik.feature.note.list.state

import ru.pyroman.masik.feature.note.list.vo.NoteListVo

sealed interface NoteListState {

    data object Idle : NoteListState

    data class Loading(
        val noteList: NoteListVo,
    ) : NoteListState

    data class Loaded(
        val noteList: NoteListVo,
    ) : NoteListState

    data class Error(
        val message: String,
    ) : NoteListState
}