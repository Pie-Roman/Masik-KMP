package ru.pyroman.masik.domain.note.list.intent

import ru.pyroman.masik.domain.note.list.model.NoteList

sealed interface NoteListIntent {

    data object Launch : NoteListIntent

    data object Load : NoteListIntent

    data class LoadForTag(
        val tagId: String,
    ) : NoteListIntent

    data object ShowLoading : NoteListIntent

    data class ShowLoaded(
        val noteList: NoteList,
    ) : NoteListIntent

    data class ShowError(
        val error: String,
    ) : NoteListIntent
}