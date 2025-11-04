package ru.pyroman.masik.feature.note.entry.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.pyroman.masik.domain.note.entry.model.NoteEntryTagListInitialData
import ru.pyroman.masik.feature.note.entry.viewmodel.NoteEntryTagListViewModel

@Composable
fun NoteEntryTagListView(
    initialData: NoteEntryTagListInitialData,
    viewModel: NoteEntryTagListViewModel = koinViewModel {
        parametersOf(initialData)
    }
) {

    val state by viewModel.state.collectAsState()
    val selectedTagIds by remember { viewModel.selectedTagIds }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Теги",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = {

            }) {
                Text(
                    text = "Новый тег",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
