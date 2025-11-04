package ru.pyroman.masik.feature.note.entry.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.pyroman.masik.domain.note.common.model.Note
import ru.pyroman.masik.domain.note.common.model.NoteBody
import ru.pyroman.masik.domain.note.entry.intent.NoteEntryIntent
import ru.pyroman.masik.domain.note.entry.model.NoteEntryInitialData
import ru.pyroman.masik.domain.note.entry.model.NoteEntryMode
import ru.pyroman.masik.domain.note.entry.model.NoteEntryTagListInitialData
import ru.pyroman.masik.feature.note.entry.state.NoteEntryState
import ru.pyroman.masik.feature.note.entry.state.NoteEntryTagListState
import ru.pyroman.masik.feature.note.entry.viewmodel.NoteEntryTagListViewModel
import ru.pyroman.masik.feature.note.entry.viewmodel.NoteEntryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEntryScreen(
    initialData: NoteEntryInitialData,
    onCancelled: () -> Unit,
    onAdded: ((Note) -> Unit)? = null,
    onUpdated: ((Note) -> Unit)? = null,
) {
    val viewModel: NoteEntryViewModel = koinViewModel {
        parametersOf(initialData)
    }
    val tagListViewModel: NoteEntryTagListViewModel = koinViewModel()
    val viewState by viewModel.state.collectAsState()
    val tagsViewState by tagListViewModel.state.collectAsState()

    val scrollState = rememberScrollState()

    var title by remember { viewModel.title }
    var link by remember { viewModel.link }

    var selectedTagIds by remember { tagListViewModel.selectedTagIds }

    LaunchedEffect(viewState) {
        when (val state = viewState) {
            is NoteEntryState.Added -> onAdded?.invoke(state.note)
            is NoteEntryState.Updated -> onUpdated?.invoke(state.note)
            else -> {}
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Что надо сделать") },
                navigationIcon = {
                    TextButton(onClick = onCancelled) {
                        Text("Отмена", color = Color(0xFF007AFF))
                    }
                },
                actions = {
                    TextButton(
                        onClick = {
                            if (title.isNotBlank()) {
                                val tags = when (val tagsState = tagsViewState) {
                                    is NoteEntryTagListState.Loaded ->
                                        tagsState.tags.filter { tag ->
                                            val tagId = selectedTagIds.find { selectedTag ->
                                                selectedTag.id == tag.id
                                            }
                                            tagId != null
                                        }
                                    else -> emptyList()
                                }

                                val body = NoteBody(
                                    title = title,
                                    isDone = false,
                                    tags = tags,
                                )

                                when (initialData.mode) {
                                    NoteEntryMode.ADD -> viewModel.send(NoteEntryIntent.Add(body))
                                    NoteEntryMode.UPDATE -> initialData.note?.let {
                                        viewModel.send(NoteEntryIntent.Update(it.id, body))
                                    }
                                }
                            }
                        },
                        enabled = title.isNotBlank()
                    ) {
                        Text(
                            "Готово",
                            fontWeight = FontWeight.SemiBold,
                            color = if (title.isNotBlank()) Color(0xFF007AFF) else Color.Gray
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .widthIn(max = 200.dp)
                        .height(80.dp)
                        .background(Color(0xFFE5E5EA), RoundedCornerShape(16.dp))
                        .padding()
                        .clickable {
                            // TODO: выбрать фото
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = "Camera",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }

            // Поле "Заметка"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFFE5E5EA), RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                TextField(
                    value = title,
                    onValueChange = { newTitle: String ->
                        viewModel.title.value = newTitle
                    },
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    label = {
                        Text("Заметка", color = Color.Gray)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Поле "Ссылка"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFFE5E5EA), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        value = link,
                        onValueChange = { newLink ->
                            viewModel.link.value = newLink
                        },
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        label = {
                            Text("Ссылка", color = Color.Gray)
                        },
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(24.dp)
                    )
                }
            }

            NoteEntryTagListView(
                initialData = NoteEntryTagListInitialData(
                    note = initialData.note,
                ),
                viewModel = tagListViewModel,
            )
        }
    }
}