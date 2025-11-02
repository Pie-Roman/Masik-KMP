package ru.pyroman.masik.feature.note.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.pyroman.masik.common.mvi.Processor
import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.feature.note.list.state.NoteListState

class NoteListViewModel(
    private val processor: Processor<NoteListIntent>,
    private val reducer: Reducer<NoteListState, NoteListIntent>,
): ViewModel() {

    private val _state = MutableStateFlow<NoteListState>(NoteListState.Idle)
    val state: StateFlow<NoteListState> = _state.asStateFlow()

    private var intentsJob: Job? = null

    fun subscribeToIntents() {
        intentsJob = viewModelScope.launch {
            processor.intentFlow.collect { intent ->
                val newState = reducer.reduce(_state.value, intent)
                _state.value = newState
            }
        }
    }

    fun send(intent: NoteListIntent) = viewModelScope.launch {
        processor.process(intent)
    }

    fun unsubscribeFromIntents() {
        intentsJob?.cancel()
        intentsJob = null
    }
}