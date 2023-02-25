package com.itx.wvsecurit.ui.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itx.wvsecurit.R;
import com.itx.wvsecurit.data.database.*;
import com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity;
import com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity;
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity;
import com.itx.wvsecurit.data.database.entities.SendMailEntity;
import com.itx.wvsecurit.data.network.GeoAlertTypeApiClient;
import com.itx.wvsecurit.data.network.GeoLocationAlertApiClient;
import com.itx.wvsecurit.data.network.SegNewsApiClient;
import com.itx.wvsecurit.data.network.SendMailService;
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository;
import com.itx.wvsecurit.databinding.ActivityMainBinding;
import com.itx.wvsecurit.di.LocationManager;
import com.itx.wvsecurit.di.MainServiceManager;
import com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase;
import com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase;
import com.itx.wvsecurit.service.LocationService;
import com.itx.wvsecurit.tool.ManagePermissions;
import com.itx.wvsecurit.tool.MyCustomDialogFragment;
import com.itx.wvsecurit.tool.MyDialog;
import com.itx.wvsecurit.ui.viewmodel.GeoLocationViewModel;
import com.itx.wvsecurit.ui.viewmodel.SharedPreferencesViewModel;
import com.nambimobile.widgets.efab.FabOption;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kH\u0002J\u0006\u0010l\u001a\u00020mJ\u0006\u0010n\u001a\u00020\u0004J\u0006\u0010o\u001a\u00020iJ\u0012\u0010p\u001a\u00020i2\b\u0010q\u001a\u0004\u0018\u00010rH\u0014J\u0010\u0010s\u001a\u00020m2\u0006\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020iH\u0014J\b\u0010w\u001a\u00020iH\u0002J\b\u0010x\u001a\u00020iH\u0002J\b\u0010y\u001a\u00020iH\u0002J\b\u0010z\u001a\u00020iH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0002028\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020F8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020L8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001e\u0010Q\u001a\u00020R8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010W\u001a\u00020X8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001b\u0010]\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010.\u001a\u0004\b_\u0010`R\u001a\u0010b\u001a\u00020cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g\u00a8\u0006{"}, d2 = {"Lcom/itx/wvsecurit/ui/view/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "PermissionsRequestCode", "", "addGeoLocationUseCase", "Lcom/itx/wvsecurit/domain/usecase/AddGeoLocationUseCase;", "getAddGeoLocationUseCase", "()Lcom/itx/wvsecurit/domain/usecase/AddGeoLocationUseCase;", "setAddGeoLocationUseCase", "(Lcom/itx/wvsecurit/domain/usecase/AddGeoLocationUseCase;)V", "addSegIncidentUseCase", "Lcom/itx/wvsecurit/domain/usecase/AddSegIncidentUseCase;", "getAddSegIncidentUseCase", "()Lcom/itx/wvsecurit/domain/usecase/AddSegIncidentUseCase;", "setAddSegIncidentUseCase", "(Lcom/itx/wvsecurit/domain/usecase/AddSegIncidentUseCase;)V", "binding", "Lcom/itx/wvsecurit/databinding/ActivityMainBinding;", "fab", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "fusedLocationProviderClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "geoAlertTypeRepository", "Lcom/itx/wvsecurit/data/database/GeoAlertTypeRepository;", "getGeoAlertTypeRepository", "()Lcom/itx/wvsecurit/data/database/GeoAlertTypeRepository;", "setGeoAlertTypeRepository", "(Lcom/itx/wvsecurit/data/database/GeoAlertTypeRepository;)V", "geoLocationAlertRepository", "Lcom/itx/wvsecurit/data/database/GeoLocationAlertRepository;", "getGeoLocationAlertRepository", "()Lcom/itx/wvsecurit/data/database/GeoLocationAlertRepository;", "setGeoLocationAlertRepository", "(Lcom/itx/wvsecurit/data/database/GeoLocationAlertRepository;)V", "geoLocationRepository", "Lcom/itx/wvsecurit/data/database/GeoLocationRepository;", "getGeoLocationRepository", "()Lcom/itx/wvsecurit/data/database/GeoLocationRepository;", "setGeoLocationRepository", "(Lcom/itx/wvsecurit/data/database/GeoLocationRepository;)V", "geoLocationViewModel", "Lcom/itx/wvsecurit/ui/viewmodel/GeoLocationViewModel;", "getGeoLocationViewModel", "()Lcom/itx/wvsecurit/ui/viewmodel/GeoLocationViewModel;", "geoLocationViewModel$delegate", "Lkotlin/Lazy;", "managePermissions", "Lcom/itx/wvsecurit/tool/ManagePermissions;", "myCustomDialog", "Lcom/itx/wvsecurit/tool/MyCustomDialogFragment;", "getMyCustomDialog", "()Lcom/itx/wvsecurit/tool/MyCustomDialogFragment;", "setMyCustomDialog", "(Lcom/itx/wvsecurit/tool/MyCustomDialogFragment;)V", "myDialog", "Lcom/itx/wvsecurit/tool/MyDialog;", "getMyDialog", "()Lcom/itx/wvsecurit/tool/MyDialog;", "setMyDialog", "(Lcom/itx/wvsecurit/tool/MyDialog;)V", "onClickListener", "Landroid/view/View$OnClickListener;", "provideGeoAlertTypeApiClient", "Lcom/itx/wvsecurit/data/network/GeoAlertTypeApiClient;", "getProvideGeoAlertTypeApiClient", "()Lcom/itx/wvsecurit/data/network/GeoAlertTypeApiClient;", "setProvideGeoAlertTypeApiClient", "(Lcom/itx/wvsecurit/data/network/GeoAlertTypeApiClient;)V", "provideGeoLocationAlertApiClient", "Lcom/itx/wvsecurit/data/network/GeoLocationAlertApiClient;", "getProvideGeoLocationAlertApiClient", "()Lcom/itx/wvsecurit/data/network/GeoLocationAlertApiClient;", "setProvideGeoLocationAlertApiClient", "(Lcom/itx/wvsecurit/data/network/GeoLocationAlertApiClient;)V", "segIncidentRepository", "Lcom/itx/wvsecurit/data/database/SegIncidentRepository;", "getSegIncidentRepository", "()Lcom/itx/wvsecurit/data/database/SegIncidentRepository;", "setSegIncidentRepository", "(Lcom/itx/wvsecurit/data/database/SegIncidentRepository;)V", "sendMailService", "Lcom/itx/wvsecurit/data/network/SendMailService;", "getSendMailService", "()Lcom/itx/wvsecurit/data/network/SendMailService;", "setSendMailService", "(Lcom/itx/wvsecurit/data/network/SendMailService;)V", "sharedPreferencesRepository", "Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;", "getSharedPreferencesRepository", "()Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;", "setSharedPreferencesRepository", "(Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;)V", "sharedPreferencesViewModel", "Lcom/itx/wvsecurit/ui/viewmodel/SharedPreferencesViewModel;", "getSharedPreferencesViewModel", "()Lcom/itx/wvsecurit/ui/viewmodel/SharedPreferencesViewModel;", "sharedPreferencesViewModel$delegate", "toggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "getToggle", "()Landroidx/appcompat/app/ActionBarDrawerToggle;", "setToggle", "(Landroidx/appcompat/app/ActionBarDrawerToggle;)V", "SaveGeoLocationAlert", "", "data", "Lcom/itx/wvsecurit/data/database/entities/GeoAlertTypeEntity;", "checkLogin", "", "getRandomColor", "loadFabs", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "requestLocation", "requestMainService", "requestStopMainService", "setFabColor", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.itx.wvsecurit.tool.ManagePermissions managePermissions;
    private final int PermissionsRequestCode = 123;
    public androidx.appcompat.app.ActionBarDrawerToggle toggle;
    private com.itx.wvsecurit.databinding.ActivityMainBinding binding;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.preferences.SharedPreferencesRepository sharedPreferencesRepository;
    private final kotlin.Lazy sharedPreferencesViewModel$delegate = null;
    private final kotlin.Lazy geoLocationViewModel$delegate = null;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.database.GeoLocationRepository geoLocationRepository;
    @javax.inject.Inject()
    public com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase addGeoLocationUseCase;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.database.SegIncidentRepository segIncidentRepository;
    @javax.inject.Inject()
    public com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase addSegIncidentUseCase;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.database.GeoAlertTypeRepository geoAlertTypeRepository;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.network.GeoAlertTypeApiClient provideGeoAlertTypeApiClient;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.database.GeoLocationAlertRepository geoLocationAlertRepository;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.network.GeoLocationAlertApiClient provideGeoLocationAlertApiClient;
    @javax.inject.Inject()
    public com.itx.wvsecurit.tool.MyDialog myDialog;
    @javax.inject.Inject()
    public com.itx.wvsecurit.tool.MyCustomDialogFragment myCustomDialog;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.network.SendMailService sendMailService;
    private com.google.android.material.floatingactionbutton.FloatingActionButton fab;
    private final android.view.View.OnClickListener onClickListener = null;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient;
    private java.util.HashMap _$_findViewCache;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.app.ActionBarDrawerToggle getToggle() {
        return null;
    }
    
    public final void setToggle(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.ActionBarDrawerToggle p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.preferences.SharedPreferencesRepository getSharedPreferencesRepository() {
        return null;
    }
    
    public final void setSharedPreferencesRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.preferences.SharedPreferencesRepository p0) {
    }
    
    private final com.itx.wvsecurit.ui.viewmodel.SharedPreferencesViewModel getSharedPreferencesViewModel() {
        return null;
    }
    
    private final com.itx.wvsecurit.ui.viewmodel.GeoLocationViewModel getGeoLocationViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.GeoLocationRepository getGeoLocationRepository() {
        return null;
    }
    
    public final void setGeoLocationRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.GeoLocationRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase getAddGeoLocationUseCase() {
        return null;
    }
    
    public final void setAddGeoLocationUseCase(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.SegIncidentRepository getSegIncidentRepository() {
        return null;
    }
    
    public final void setSegIncidentRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.SegIncidentRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase getAddSegIncidentUseCase() {
        return null;
    }
    
    public final void setAddSegIncidentUseCase(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.GeoAlertTypeRepository getGeoAlertTypeRepository() {
        return null;
    }
    
    public final void setGeoAlertTypeRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.GeoAlertTypeRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.network.GeoAlertTypeApiClient getProvideGeoAlertTypeApiClient() {
        return null;
    }
    
    public final void setProvideGeoAlertTypeApiClient(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.GeoAlertTypeApiClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.GeoLocationAlertRepository getGeoLocationAlertRepository() {
        return null;
    }
    
    public final void setGeoLocationAlertRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.GeoLocationAlertRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.network.GeoLocationAlertApiClient getProvideGeoLocationAlertApiClient() {
        return null;
    }
    
    public final void setProvideGeoLocationAlertApiClient(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.GeoLocationAlertApiClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.tool.MyDialog getMyDialog() {
        return null;
    }
    
    public final void setMyDialog(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.tool.MyDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.tool.MyCustomDialogFragment getMyCustomDialog() {
        return null;
    }
    
    public final void setMyCustomDialog(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.tool.MyCustomDialogFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.network.SendMailService getSendMailService() {
        return null;
    }
    
    public final void setSendMailService(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.SendMailService p0) {
    }
    
    private final void SaveGeoLocationAlert(com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity data) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void loadFabs() {
    }
    
    public final int getRandomColor() {
        return 0;
    }
    
    public final boolean checkLogin() {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void requestStopMainService() {
    }
    
    private final void requestMainService() {
    }
    
    private final void setFabColor() {
    }
    
    private final void requestLocation() {
    }
}