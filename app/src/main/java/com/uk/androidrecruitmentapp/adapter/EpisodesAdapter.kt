package com.uk.androidrecruitmentapp.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.uk.androidrecruitmentapp.databinding.RowEpisodeBinding
import com.uk.androidrecruitmentapp.model.Episode

class EpisodesAdapter(private val interaction: Interaction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowEpisodeBinding.inflate(inflater, parent, false)

        return EpisodesViewHolder(binding, interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EpisodesViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Episode>) {
        differ.submitList(list)
    }

    class EpisodesViewHolder
    constructor(
            private val binding: RowEpisodeBinding,
            private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: Episode) {
            binding.episode = episode
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Episode)
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Episode>() {

            override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean =
                    oldItem == newItem

        }
    }
}