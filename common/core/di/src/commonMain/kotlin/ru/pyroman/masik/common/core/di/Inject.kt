package ru.pyroman.news.common.core.di

import org.kodein.di.DirectDI
import org.kodein.di.instance

object Inject {

    private var _di: DirectDI? = null

    val di: DirectDI
        get() = requireNotNull(_di)

    fun createDependencies(tree: DirectDI) {
        _di = tree
    }

    inline fun <reified T> instance(
        tag: Any? = null,
    ): T {
        return di.instance(tag)
    }

    fun taggedInstance(tag: Any?): Any {
        return di.instance(tag)
    }
}