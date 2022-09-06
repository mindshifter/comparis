package ch.comparis.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ch.comparis.R
import ch.comparis.databinding.ItemMakeBinding
import ch.comparis.model.Make

class MakesAdapter(private val makeFavoriteListener: (Make) -> Unit) :
    RecyclerView.Adapter<MakesAdapter.MakeViewHolder>() {
    private var makes: MutableList<Make> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeViewHolder {
        val binding = ItemMakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MakeViewHolder(binding)
    }

    class MakeViewHolder(val binding: ItemMakeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MakeViewHolder, position: Int) {
        val make = makes[position]
        with(holder) {
            binding.isFavoriteButton.setImageResource(if (make.isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)
            binding.makeName.text = make.name
            binding.isFavoriteButton.setOnClickListener {
                make.isFavorite = !make.isFavorite
                makeFavoriteListener.invoke(make)
            }
        }
    }

    override fun getItemCount(): Int = makes.size

    fun updateMakes(it: MutableList<Make>?) {
        it?.let {
            makes = it
            notifyDataSetChanged()
        }
    }
}
