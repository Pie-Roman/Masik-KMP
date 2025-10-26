package ru.pyroman.masik.domain.note.entry.processor

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.pyroman.masik.common.mvi.Processor
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryIntent
import ru.pyroman.masik.domain.note.entry.repository.NoteEntryRepository

internal class NoteEntryProcessor(
    private val repository: NoteEntryRepository,
) : Processor<NoteEntryIntent>() {

    override suspend fun process(intent: NoteEntryIntent) {
        when (intent) {
            is NoteEntryIntent.Add -> {
                coroutineScope {
                    launch {
                        val noteEntry = repository.add(
                            noteBody = intent.body,
                        )
                        _intentFlow.emit(
                            NoteEntryIntent.ShowAdded(
                                note = noteEntry,
                            )
                        )
                    }
                }
            }

            is NoteEntryIntent.Update -> {
                coroutineScope {
                    launch {
                        val noteEntry = repository.update(
                            id = intent.id,
                            noteBody = intent.body,
                        )
                        _intentFlow.emit(
                            NoteEntryIntent.ShowUpdated(
                                note = noteEntry,
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