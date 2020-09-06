package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.model.Character
import com.uk.androidrecruitmentapp.model.ResponseCharacter
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var currentPage = 1
    var allPages = 0

    private val _charactersData = MutableLiveData<Response<ResponseCharacter>>()
    val charactersData: LiveData<Response<ResponseCharacter>> = _charactersData

    val characterList = mutableListOf<Character>()

    private fun getCharacters() {
        viewModelScope.launch {
            _charactersData.value = repository.getCharacter(currentPage)
        }
    }

    fun getCharactersFromNextPage() {
        currentPage += 1
        if (currentPage <= allPages) {
            getCharacters()
        }
    }

    init {
        getCharacters()
    }
}