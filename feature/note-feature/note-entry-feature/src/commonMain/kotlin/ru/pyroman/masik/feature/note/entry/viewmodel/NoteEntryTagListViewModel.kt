package ru.pyroman.masik.feature.note.entry.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.pyroman.masik.common.mvi.Processor
import ru.pyroman.masik.common.mvi.Reducer
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryTagListIntent
import ru.pyroman.masik.domain.note.entry.model.NoteEntryTagListInitialData
import ru.pyroman.masik.feature.note.entry.state.NoteEntryTagListState

class NoteEntryTagListViewModel(
    private val initialData: NoteEntryTagListInitialData,
    private val processor: Processor<NoteEntryTagListIntent>,
    private val reducer: Reducer<NoteEntryTagListState, NoteEntryTagListIntent>,
): ViewModel() {

    private val _state = MutableStateFlow<NoteEntryTagListState>(NoteEntryTagListState.Idle)
    val state: StateFlow<NoteEntryTagListState> = _state.asStateFlow()

    val selectedTagIds = mutableStateOf(initialData.note?.body?.tags.orEmpty())

    private var intentsJob: Job? = null

    fun subscribeToIntents() {
        intentsJob = viewModelScope.launch {
            processor.intentFlow.collect { intent ->
                val newState = reducer.reduce(_state.value, intent)
                _state.value = newState
            }
        }
    }

    fun send(intent: NoteEntryTagListIntent) = viewModelScope.launch {
        processor.process(intent)
    }

    override fun onCleared() {
        super.onCleared()
        intentsJob?.cancel()
        intentsJob = null
    }
}