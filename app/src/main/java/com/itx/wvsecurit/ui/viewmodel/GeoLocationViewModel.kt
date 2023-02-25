package com.itx.wvsecurit.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GeoLocationViewModel @Inject constructor(): ViewModel() {
    var geoLocationList = MutableLiveData<List<GeoLocationEntity>>()

}