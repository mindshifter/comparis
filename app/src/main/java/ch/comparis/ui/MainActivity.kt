package ch.comparis.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import ch.comparis.databinding.ActivityMainBinding
import ch.comparis.model.MakesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var makesViewModel: MakesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makesViewModel = ViewModelProvider(this).get()
        makesViewModel.favoritesCount.observe(this) {
            binding.makesFavoriteCount.text = it.toString()
        }
        binding.addToFavorites.setOnClickListener {
            val intent = Intent(this, MakesActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        makesViewModel.getFavoriteCount()
    }
}