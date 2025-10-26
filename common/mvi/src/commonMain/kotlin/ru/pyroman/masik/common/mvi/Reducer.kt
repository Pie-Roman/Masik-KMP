package ru.pyroman.masik.common.mvi

interface Reducer<State, Intent> {

    fun reduce(currentState: State, intent: Intent): State
}