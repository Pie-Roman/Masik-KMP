package ru.pyroman.masik.domain.note.entry.processor

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.pyroman.masik.common.mvi.Processor
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryTagListIntent
import ru.pyroman.masik.domain.note.entry.repository.NoteEntryTagListRepository

internal class NoteEntryTagListProcessor(
    private val repository: NoteEntryTagListRepository,
) : Processor<NoteEntryTagListIntent>() {

    override suspend fun process(intent: NoteEntryTagListIntent) {
        when (intent) {
            is NoteEntryTagListIntent.Load -> {
                coroutineScope {
                    launch {
                        val tags = repository.getTags()
                        _intentFlow.emit(
                            NoteEntryTagListIntent.ShowLoaded(
                                tags = tags,
                            )
                        )
                    }
                }
            }

            else -> {
                _intentFlow.emit(intent)
            }
        }
    }
}