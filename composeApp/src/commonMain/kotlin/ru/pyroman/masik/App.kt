package ru.pyroman.masik

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.pyroman.masik.feature.tabs.view.TabsView

@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ContentView(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    TabsView(modifier)
}