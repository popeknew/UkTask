package com.uk.androidrecruitmentapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.uk.androidrecruitmentapp.databinding.RowLocationBinding
import com.uk.androidrecruitmentapp.model.Location

class LocationAdapter(private val interaction: Interaction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowLocationBinding.inflate(inflater, parent, false)

        return LocationViewHolder(binding, interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LocationViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Location>) {
        differ.submitList(list)
    }

    class LocationViewHolder
    constructor(
            private val binding: RowLocationBinding,
            private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(location: Location) {
            binding.location = location
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Location)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Location>() {

            override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean =
                    oldItem == newItem

        }
    }
}