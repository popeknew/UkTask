package com.uk.androidrecruitmentapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uk.androidrecruitmentapp.R
import com.uk.androidrecruitmentapp.adapter.CharactersAdapter
import com.uk.androidrecruitmentapp.model.Character
import com.uk.androidrecruitmentapp.vm.CharactersViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlinx.android.synthetic.main.fragment_characters.view.*
import javax.inject.Inject

class CharactersFragment : DaggerFragment(R.layout.fragment_characters), CharactersAdapter.Interaction {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: CharactersViewModel by viewModels { vmFactory }

    lateinit var adapter: CharactersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.charactersData.observe(viewLifecycleOwner, Observer { characters ->
            adapter.submitList(characters)
        })
    }

    private fun setupRecyclerView() {
        adapter = CharactersAdapter(this)
        characters_recycler_view.adapter = adapter
    }

    override fun onItemSelected(position: Int, item: Character) {
        TODO("Not yet implemented")
    }
}