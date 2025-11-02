package ru.pyroman.masik.feature.note.list.vo

import ru.pyroman.masik.domain.note.common.model.NoteTag

class NoteListVo(
    val tags: List<NoteTag>,
    val leftColumn: List<NoteListItemVo>,
    val rightColumn: List<NoteListItemVo>,
)