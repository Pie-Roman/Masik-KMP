package ru.pyroman.masik.feature.note.list.reducer

import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.feature.note.list.formatter.NoteListFormatter
import ru.pyroman.masik.feature.note.list.state.NoteListState
import ru.pyroman.masik.feature.note.list.vo.NoteListVo

internal class NoteListReducer(
    private val noteListFormatter: NoteListFormatter,
): Reducer<NoteListState, NoteListIntent> {

    override fun reduce(currentState: NoteListState, intent: NoteListIntent): NoteListState {
        return when (intent) {
            is NoteListIntent.ShowLoading -> {
                if (currentState is NoteListState.Loaded) {
                    NoteListState.Loading(
                        noteList = currentState.noteList,
                    )
                } else {
                    NoteListState.Loading(
                        noteList = NoteListVo(
                            tags = emptyList(),
                            leftColumn = emptyList(),
                            rightColumn = emptyList(),
                        )
                    )
                }
            }

            is NoteListIntent.ShowLoaded -> {
                val noteList = noteListFormatter.format(intent.noteList)
                NoteListState.Loaded(
                    noteList = noteList,
                )
            }

            is NoteListIntent.ShowError -> {
                NoteListState.Error(
                    message = intent.error,
                )
            }

            else -> {
                currentState
            }
        }
    }
}