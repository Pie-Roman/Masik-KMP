package ru.pyroman.masik.feature.note.list.viewmodel

import androidx.lifecycle.ViewModel
import ru.pyroman.masik.domain.note.list.repository.NoteListTagsRepository

class NoteListTabsViewModel(
    repository: NoteListTagsRepository,
) : ViewModel() {

    val tags = repository.getTags()
}