package ru.pyroman.news.common.core.di.module

import org.kodein.di.DI
import ru.pyroman.news.common.core.di.module

abstract class Module {

    abstract val name: String

    private var _instance: DI.Module? = null

    val instance: DI.Module
        get() = _instance ?: throw NoSuchElementException("Module was not assembled!")

    protected fun assemble(
        childModules: List<DI.Module>,
        bridge: ModuleBridge,
    ) {
        if (_instance == null) {
            _instance = module(name) {
                importAll(childModules)
                bridge.provideInstances(this)
            }
        }
    }
}