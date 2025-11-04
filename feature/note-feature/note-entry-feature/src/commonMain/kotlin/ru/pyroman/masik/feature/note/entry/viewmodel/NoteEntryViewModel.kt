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
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryIntent
import ru.pyroman.masik.domain.note.entry.model.NoteEntryInitialData
import ru.pyroman.masik.feature.note.entry.state.NoteEntryState

class NoteEntryViewModel(
    private val initialData: NoteEntryInitialData,
    private val processor: Processor<NoteEntryIntent>,
    private val reducer: Reducer<NoteEntryState, NoteEntryIntent>,
): ViewModel() {

    private val _state = MutableStateFlow<NoteEntryState>(NoteEntryState.Idle)
    val state: StateFlow<NoteEntryState> = _state.asStateFlow()

    val title = mutableStateOf(initialData.note?.body?.title.orEmpty())
    val link = mutableStateOf("")

    private var intentsJob: Job? = null

    fun subscribeToIntents() {
        intentsJob = viewModelScope.launch {
            processor.intentFlow.collect { intent ->
                val newState = reducer.reduce(_state.value, intent)
                _state.value = newState
            }
        }
    }

    fun send(intent: NoteEntryIntent) = viewModelScope.launch {
        processor.process(intent)
    }

    override fun onCleared() {
        super.onCleared()
        intentsJob?.cancel()
        intentsJob = null
    }
}