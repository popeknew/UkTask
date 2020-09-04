package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.ViewModel
import com.uk.androidrecruitmentapp.repo.Repository
import javax.inject.Inject

class LocationsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
}