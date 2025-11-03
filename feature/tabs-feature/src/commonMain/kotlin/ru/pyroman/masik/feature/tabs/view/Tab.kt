package ru.pyroman.masik.feature.tabs.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

internal enum class Tab(val icon: ImageVector) {
    Main(Icons.Filled.Home),
    Notes(Icons.AutoMirrored.Filled.List),
    Wishlist(Icons.Filled.Favorite);
}