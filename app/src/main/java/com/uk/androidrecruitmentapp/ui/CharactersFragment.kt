package com.uk.androidrecruitmentapp.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uk.androidrecruitmentapp.R
import com.uk.androidrecruitmentapp.adapter.CharactersAdapter
import com.uk.androidrecruitmentapp.error.MyError
import com.uk.androidrecruitmentapp.ext.setVisible
import com.uk.androidrecruitmentapp.ext.snackbar
import com.uk.androidrecruitmentapp.model.Character
import com.uk.androidrecruitmentapp.model.ResponseCharacter
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.vm.CharactersViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_characters.progress_bar
import kotlinx.android.synthetic.main.fragment_characters.characters_recycler_view
import kotlinx.android.synthetic.main.fragment_characters.characters_layout
import javax.inject.Inject

class CharactersFragment : DaggerFragment(R.layout.fragment_characters), CharactersAdapter.Interaction {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: CharactersViewModel by viewModels { vmFactory }
    lateinit var adapter: CharactersAdapter

    private val charactersObserver = Observer<Response<ResponseCharacter>> { response ->
        when(response) {
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
        viewModel.charactersData.observe(viewLifecycleOwner, charactersObserver)
    }

    private fun setupRecyclerView() {
        adapter = CharactersAdapter(this)
        characters_recycler_view.adapter = adapter
    }

    private fun handleError(error: MyError) {
        when(error) {
            is MyError.ServerError -> showSnackBar(R.string.server_error)
            is MyError.ServerUnavailable -> showSnackBar(R.string.server_unavailable)
            else -> showSnackBar(R.string.something_went_wrong)
        }
    }

    private fun showSnackBar(@StringRes messageId: Int) =
            characters_layout.snackbar(messageId, true)

    override fun onItemSelected(position: Int, item: Character) {
        TODO("Not yet implemented")
    }
}