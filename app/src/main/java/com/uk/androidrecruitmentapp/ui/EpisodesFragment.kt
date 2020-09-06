package com.uk.androidrecruitmentapp.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uk.androidrecruitmentapp.R
import com.uk.androidrecruitmentapp.adapter.EpisodesAdapter
import com.uk.androidrecruitmentapp.error.MyError
import com.uk.androidrecruitmentapp.ext.setVisible
import com.uk.androidrecruitmentapp.ext.snackbar
import com.uk.androidrecruitmentapp.model.Episode
import com.uk.androidrecruitmentapp.model.ResponseEpisode
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.vm.EpisodesViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_episodes.episodes_layout
import kotlinx.android.synthetic.main.fragment_episodes.progress_bar
import kotlinx.android.synthetic.main.fragment_episodes.episodes_recycler_view
import javax.inject.Inject

class EpisodesFragment : DaggerFragment(R.layout.fragment_episodes), EpisodesAdapter.Interaction {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: EpisodesViewModel by viewModels { vmFactory }
    private lateinit var adapter: EpisodesAdapter

    private val charactersObserver = Observer<Response<ResponseEpisode>> { response ->
        when (response) {
            is Response.Success -> {
                adapter.submitList(response.data.results)
                progress_bar.setVisible(false)
            }
            is Response.Failure -> handleError(response.error)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.episodesData.observe(viewLifecycleOwner, charactersObserver)
    }

    private fun setupRecyclerView() {
        adapter = EpisodesAdapter(this)
        episodes_recycler_view.adapter = adapter
    }

    private fun handleError(error: MyError) {
        when(error) {
            is MyError.ServerError -> showSnackBar(R.string.server_error)
            is MyError.ServerUnavailable -> showSnackBar(R.string.server_unavailable)
            else -> showSnackBar(R.string.something_went_wrong)
        }
    }

    private fun showSnackBar(@StringRes messageId: Int) =
            episodes_layout.snackbar(messageId, true)

    override fun onItemSelected(position: Int, item: Episode) {
        TODO("Not yet implemented")
    }
}