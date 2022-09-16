package net.devonmobile.kmmovies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform