package ru.pyroman.masik.common.mvi

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

abstract class Processor<Intent> {

    val intentFlow: SharedFlow<Intent>
        get() = _intentFlow

    protected val _intentFlow: MutableSharedFlow<Intent> = MutableSharedFlow()

    abstract suspend fun process(intent: Intent)
}