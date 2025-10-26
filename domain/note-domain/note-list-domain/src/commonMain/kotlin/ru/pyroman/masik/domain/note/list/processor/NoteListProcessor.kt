package ru.pyroman.masik.domain.note.list.processor

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.pyroman.masik.common.mvi.Processor
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.domain.note.list.repository.NoteListRepository

internal class NoteListProcessor(
    private val repository: NoteListRepository,
) : Processor<NoteListIntent>() {

    override suspend fun process(intent: NoteListIntent) {
        when (intent) {
            is NoteListIntent.Launch -> {
                coroutineScope {
                    launch {
                        try {
                            repository.launch()
                            process(
                                intent = NoteListIntent.Load
                            )
                        } catch (error: Throwable) {
                            _intentFlow.emit(
                                NoteListIntent.ShowError(
                                    error = error.message.orEmpty(),
                                )
                            )
                        }
                    }
                }
            }

            is NoteListIntent.Load -> {
                _intentFlow.emit(
                    NoteListIntent.ShowLoading
                )

                coroutineScope {
                    launch {
                        try {
                            val noteList = repository.getNotes(
                                tagId = null,
                            )
                            _intentFlow.emit(
                                NoteListIntent.ShowLoaded(
                                    noteList = noteList,
                                )
                            )
                        } catch (error: Throwable) {
                            _intentFlow.emit(
                                NoteListIntent.ShowError(
                                    error = error.message.orEmpty(),
                                )
                            )
                        }
                    }
                }
            }

            is NoteListIntent.LoadForTag -> {
                _intentFlow.emit(
                    NoteListIntent.ShowLoading
                )

                coroutineScope {
                    launch {
                        try {
                            val noteList = repository.getNotes(
                                tagId = intent.tagId,
                            )
                            _intentFlow.emit(
                                NoteListIntent.ShowLoaded(
                                    noteList = noteList,
                                )
                            )
                        } catch (error: Throwable) {
                            _intentFlow.emit(
                                NoteListIntent.ShowError(
                                    error = error.message.orEmpty(),
                                )
                            )
                        }
                    }
                }
            }

            else -> {
                _intentFlow.emit(intent)
            }
        }
    }
}