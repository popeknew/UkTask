package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.model.Character
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _charactersData = MutableLiveData<List<Character>>()
    val charactersData: LiveData<List<Character>> = _charactersData

    private fun getAllCharacters() {
        viewModelScope.launch {
            val response = repository.getAllCharacaters()
            if (response.isSuccessful) {
                _charactersData.value = response.body()?.results
            }
        }
    }

    init {
        getAllCharacters()
    }
}