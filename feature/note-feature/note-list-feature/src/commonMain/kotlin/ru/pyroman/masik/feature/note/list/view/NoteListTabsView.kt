package ru.pyroman.masik.feature.note.list.view

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import ru.pyroman.masik.domain.note.common.model.NoteTag
import ru.pyroman.masik.feature.note.list.viewmodel.NoteListTabsViewModel

@Composable
fun NoteListTabsView(
    onTabTapAction: (NoteTag?) -> Unit,
    content: @Composable () -> Unit
) {
    val viewModel: NoteListTabsViewModel = koinViewModel()
    val tags by viewModel.tags.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(top = 8.dp),
            verticalAlignment = Alignment.Top
        ) {
            NoteListTabView(
                name = "Все",
                color = Color(0xFFE5E5E5),
                onClick = { onTabTapAction(null) }
            )

            tags.forEach { tag ->
                NoteListTabView(
                    name = tag.name,
                    color = try {
                        Color(tag.color.toColorInt())
                    } catch (_: IllegalArgumentException) {
                        Color(0xFFE5E5E5)
                    },
                    onClick = { onTabTapAction(tag) }
                )
            }
        }

        content()
    }
}

@Composable
private fun NoteListTabView(
    name: String,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.Black
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

private fun String.toColorInt(): Int {
    val cleanHex = this
        .removePrefix("#")
        .trim()

    val fullHex = when (cleanHex.length) {
        3 -> cleanHex.map { "$it$it" }.joinToString("")
        6 -> "FF$cleanHex"
        8 -> cleanHex
        else -> error("Invalid color format: $this")
    }

    return fullHex.toLong(16).toInt()
}