package ru.pyroman.masik

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform