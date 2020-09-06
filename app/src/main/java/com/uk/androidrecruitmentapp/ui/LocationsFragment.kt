package com.uk.androidrecruitmentapp.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uk.androidrecruitmentapp.R
import com.uk.androidrecruitmentapp.adapter.LocationAdapter
import com.uk.androidrecruitmentapp.error.MyError
import com.uk.androidrecruitmentapp.ext.setVisible
import com.uk.androidrecruitmentapp.ext.snackbar
import com.uk.androidrecruitmentapp.model.Location
import com.uk.androidrecruitmentapp.model.ResponseLocation
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.utils.EndlessRecyclerViewScrollListener
import com.uk.androidrecruitmentapp.vm.LocationsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_locations.locations_layout
import kotlinx.android.synthetic.main.fragment_locations.progress_bar
import kotlinx.android.synthetic.main.fragment_locations.locations_recycler_view
import javax.inject.Inject

class LocationsFragment : DaggerFragment(R.layout.fragment_locations), LocationAdapter.Interaction {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: LocationsViewModel by viewModels { vmFactory }
    private lateinit var adapter: LocationAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var endlessRecyclerViewScrollListener: EndlessRecyclerViewScrollListener

    private val locationObserver = Observer<Response<ResponseLocation>> { response ->
        when (response) {
            is Response.Success -> {
                with(viewModel) {
                    allPages = response.data.info.pages
                    locationList.addAll(response.data.results)
                    adapter.submitList(locationList)
                    adapter.notifyDataSetChanged()
                }
            }
            is Response.Failure -> handleError(response.error)
        }
        progress_bar.setVisible(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(context)
        initializeEndlessScrollListener()
        setupRecyclerView()

        viewModel.locationsData.observe(viewLifecycleOwner, locationObserver)
    }

    private fun setupRecyclerView() {
        adapter = LocationAdapter(this)
        with(locations_recycler_view) {
            adapter = this@LocationsFragment.adapter
            layoutManager = this@LocationsFragment.layoutManager
            addOnScrollListener(endlessRecyclerViewScrollListener)
        }
    }

    private fun initializeEndlessScrollListener() {
        endlessRecyclerViewScrollListener =
                object : EndlessRecyclerViewScrollListener(layoutManager) {
                    override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                        viewModel.getLocationsFromNextPage()
                    }
                }
    }

    private fun handleError(error: MyError) {
        when (error) {
            is MyError.ServerError -> showSnackBar(R.string.server_error)
            is MyError.ServerUnavailable -> showSnackBar(R.string.server_unavailable)
            else -> showSnackBar(R.string.something_went_wrong)
        }
    }

    private fun showSnackBar(@StringRes messageId: Int) =
            locations_layout.snackbar(messageId, true)

    override fun onItemSelected(position: Int, item: Location) {
        TODO("Not yet implemented")
    }

}