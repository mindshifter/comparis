package ch.comparis.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import ch.comparis.databinding.ActivityMainBinding
import ch.comparis.databinding.ActivityMakesBinding
import ch.comparis.model.Make
import ch.comparis.model.MakesViewModel
import ch.comparis.ui.adapters.MakesAdapter

class MakesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMakesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val makesViewModel = ViewModelProvider(this).get<MakesViewModel>()
        val makesAdapter = MakesAdapter {
            when {
                it.isFavorite -> makesViewModel.addMakeToFavorite(it)
                else -> makesViewModel.removeMakeFromFavorite(it)
            }
        }
        with(binding.makesRecyclerView) {
            adapter = makesAdapter
            layoutManager = LinearLayoutManager(this@MakesActivity)
        }
        makesViewModel.makesLiveData.observe(this) {
            makesAdapter.updateMakes(it)
        }
    }
}