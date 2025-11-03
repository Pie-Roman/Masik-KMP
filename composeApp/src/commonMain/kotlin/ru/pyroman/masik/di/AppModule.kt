package ru.pyroman.masik.di

import org.koin.dsl.module
import ru.pyroman.masik.feature.tabs.di.tabsFeatureModule

val appModule = module {
    includes(
        tabsFeatureModule
    )
}