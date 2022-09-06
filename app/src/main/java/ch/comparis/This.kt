package ch.comparis

import android.app.Application
import ch.comparis.repo.MakesLocalRepo

class This : Application() {
    companion object {
        val localRepo = MakesLocalRepo()
    }
}