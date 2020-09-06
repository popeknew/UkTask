package com.uk.androidrecruitmentapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.uk.androidrecruitmentapp.databinding.RowCharacterBinding
import com.uk.androidrecruitmentapp.model.Character

class CharactersAdapter(private val interaction: Interaction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowCharacterBinding.inflate(inflater, parent, false)

        return CharacterViewHolder(binding, interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Character>) {
        differ.submitList(list)
    }

    class CharacterViewHolder
    constructor(
            private val binding: RowCharacterBinding,
            private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.character = character
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Character)
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Character>() {

            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
                    oldItem == newItem

        }
    }
}