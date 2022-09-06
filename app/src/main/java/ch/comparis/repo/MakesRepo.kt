package ch.comparis.repo

import ch.comparis.model.Make

interface MakesRepo {
    fun getMakes(): MutableList<Make>
    fun addMakeToFavorite(makeName: String)
    fun removeMakeFromFavorite(makeName: String)
    fun countFavorites(): Int
}
