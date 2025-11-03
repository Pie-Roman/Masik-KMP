package ru.pyroman.masik.feature.tabs.di

import org.koin.dsl.module
import ru.pyroman.masik.feature.note.list.di.noteListFeatureModule

val tabsFeatureModule = module {
    includes(
        noteListFeatureModule
    )
}