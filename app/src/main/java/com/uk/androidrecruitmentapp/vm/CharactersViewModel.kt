package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.model.ResponseCharacter
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _charactersData = MutableLiveData<Response<ResponseCharacter>>()
    val charactersData: LiveData<Response<ResponseCharacter>> = _charactersData

    private fun getCharacters() {
        viewModelScope.launch {
            _charactersData.value = repository.getAllCharacters()
        }
    }

    init {
        getCharacters()
    }
}