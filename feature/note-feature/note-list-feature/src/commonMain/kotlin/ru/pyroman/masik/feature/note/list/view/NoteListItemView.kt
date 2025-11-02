package ru.pyroman.masik.feature.note.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.pyroman.masik.feature.note.list.vo.NoteListItemVo

@Composable
fun NoteListItemView(
    note: NoteListItemVo,
    onUpdateTap: () -> Unit,
) {

    var isActionsPresented by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((120 + note.heightOffset * 40).dp)
            .clip(RoundedCornerShape(24.dp))
            .background(note.backgroundColor)
    ) {
        Text(
            text = note.body.title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )

        IconButton(
            onClick = { isActionsPresented = true },
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "Actions",
                tint = Color.Black.copy(alpha = 0.7f)
            )
        }
    }
}
