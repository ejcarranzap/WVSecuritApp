package com.itx.wvsecurit.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor() : ViewModel() {
    var isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(false)
        }
    }
}