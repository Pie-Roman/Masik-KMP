package ru.pyroman.masik.feature.note.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.pyroman.masik.feature.note.list.vo.NoteListItemVo
import ru.pyroman.masik.feature.note.list.vo.NoteListVo

@Composable
internal fun NoteListLoadedView(
    noteList: NoteListVo,
    onUpdate: (NoteListItemVo) -> Unit,
) {
    if (noteList.leftColumn.isEmpty() && noteList.rightColumn.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Список дел пуст", color = Color.Gray, style = MaterialTheme.typography.titleMedium)
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    NoteListLoadedColumnView(
                        items = noteList.leftColumn,
                        onUpdate = onUpdate,
                    )
                    Spacer(Modifier.width(12.dp))
                    NoteListLoadedColumnView(
                        items = noteList.rightColumn,
                        onUpdate = onUpdate,
                    )
                }
            }
        }
    }
}

@Composable
private fun RowScope.NoteListLoadedColumnView(
    items: List<NoteListItemVo>,
    onUpdate: (NoteListItemVo) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.weight(1f)
    ) {
        items.forEach { note ->
            NoteListItemView(
                note = note,
                onUpdateTap = { onUpdate(note) },
            )
        }
    }
}
