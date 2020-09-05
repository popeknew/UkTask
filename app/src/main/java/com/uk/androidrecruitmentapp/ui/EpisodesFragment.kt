package com.uk.androidrecruitmentapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uk.androidrecruitmentapp.R
import com.uk.androidrecruitmentapp.adapter.EpisodesAdapter
import com.uk.androidrecruitmentapp.model.Episode
import com.uk.androidrecruitmentapp.vm.EpisodesViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_episodes.episodes_recycler_view
import javax.inject.Inject

class EpisodesFragment : DaggerFragment(R.layout.fragment_episodes), EpisodesAdapter.Interaction {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: EpisodesViewModel by viewModels { vmFactory }

    private lateinit var adapter: EpisodesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.episodesData.observe(viewLifecycleOwner, Observer { episodes ->
            adapter.submitList(episodes)
        })
    }

    private fun setupRecyclerView() {
        adapter = EpisodesAdapter(this)
        episodes_recycler_view.adapter = adapter
    }

    override fun onItemSelected(position: Int, item: Episode) {
        TODO("Not yet implemented")
    }
}