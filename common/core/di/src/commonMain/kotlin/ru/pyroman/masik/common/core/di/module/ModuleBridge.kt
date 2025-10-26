package ru.pyroman.news.common.core.di.module

import org.kodein.di.DI

abstract class ModuleBridge {

    fun provideInstances(builder: DI.Builder) {
        provideBridgeInstances(builder)
        provideNativeInstances(builder)
    }

    protected open fun provideBridgeInstances(builder: DI.Builder) {
        // no-op
    }

    protected open fun provideNativeInstances(builder: DI.Builder) {
        // no-op
    }
}