package com.uk.androidrecruitmentapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uk.androidrecruitmentapp.R
import com.uk.androidrecruitmentapp.adapter.LocationAdapter
import com.uk.androidrecruitmentapp.model.Location
import com.uk.androidrecruitmentapp.vm.LocationsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_locations.locations_recycler_view
import javax.inject.Inject

class LocationsFragment : DaggerFragment(R.layout.fragment_locations), LocationAdapter.Interaction {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: LocationsViewModel by viewModels { vmFactory }
    private lateinit var adapter: LocationAdapter

    private val locationObserver = Observer<List<Location>> { locations ->
        adapter.submitList(locations)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.locationsData.observe(viewLifecycleOwner, locationObserver)
    }

    private fun setupRecyclerView() {
        adapter = LocationAdapter(this)
        locations_recycler_view.adapter = adapter
    }

    override fun onItemSelected(position: Int, item: Location) {
        TODO("Not yet implemented")
    }

}