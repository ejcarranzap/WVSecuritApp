package com.itx.wvsecurit.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/itx/wvsecurit/ui/viewmodel/GeoLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "geoLocationList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/itx/wvsecurit/data/database/entities/GeoLocationEntity;", "getGeoLocationList", "()Landroidx/lifecycle/MutableLiveData;", "setGeoLocationList", "(Landroidx/lifecycle/MutableLiveData;)V", "app_debug"})
public final class GeoLocationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.util.List<com.itx.wvsecurit.data.database.entities.GeoLocationEntity>> geoLocationList;
    
    @javax.inject.Inject
    public GeoLocationViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.itx.wvsecurit.data.database.entities.GeoLocationEntity>> getGeoLocationList() {
        return null;
    }
    
    public final void setGeoLocationList(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.util.List<com.itx.wvsecurit.data.database.entities.GeoLocationEntity>> p0) {
    }
}