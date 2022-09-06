package ch.comparis.repo

import ch.comparis.model.Make

class MakesLocalRepo : MakesRepo {
    private var localMakes = mutableListOf(
        Make("Audi"),
        Make("BMW"),
        Make("Tesla"),
        Make("Volkswagen"),
        Make("Toyota"),
        Make("Mazda"),
        Make("Volvo"),
        Make("Subaru")
    )

    override fun getMakes(): MutableList<Make> {
        return localMakes
    }

    override fun addMakeToFavorite(makeName: String) {
        localMakes.find { it.name == makeName }?.isFavorite = true
    }

    override fun removeMakeFromFavorite(makeName: String) {
        localMakes.find { it.name == makeName }?.isFavorite = false
    }

    override fun countFavorites(): Int = localMakes.count { it.isFavorite }
}