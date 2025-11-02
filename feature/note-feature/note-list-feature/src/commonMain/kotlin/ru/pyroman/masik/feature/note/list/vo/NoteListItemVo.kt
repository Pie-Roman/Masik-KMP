package ru.pyroman.masik.feature.note.list.vo

import androidx.compose.ui.graphics.Color
import ru.pyroman.masik.domain.note.common.model.NoteBody

data class NoteListItemVo(
    val id: String,
    val body: NoteBody,
    val heightOffset: Int,
    val backgroundColor: Color,
)