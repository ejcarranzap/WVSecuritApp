package com.itx.wvsecurit.ui.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.itx.common.jcdata.CustomResponse;
import com.itx.wvsecurit.R;
import com.itx.wvsecurit.data.database.SegIncidentRepository;
import com.itx.wvsecurit.data.database.SegIncidentTypeRepository;
import com.itx.wvsecurit.data.database.entities.FileEntity;
import com.itx.wvsecurit.data.database.entities.SegIncidentEntity;
import com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity;
import com.itx.wvsecurit.data.network.SegIncidentApiClient;
import com.itx.wvsecurit.data.network.UploadService;
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository;
import com.itx.wvsecurit.databinding.ActivityIncidentBinding;
import com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase;
import com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase;
import com.itx.wvsecurit.domain.usecase.GetSegIncidentTypeUseCase;
import com.itx.wvsecurit.tool.MyDialog;
import com.itx.wvsecurit.tool.MyImageTool;
import com.itx.wvsecurit.tool.Report;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.io.File;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0012H\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0012H\u0002J\b\u0010R\u001a\u00020KH\u0002J\b\u0010S\u001a\u00020KH\u0002J\b\u0010T\u001a\u0004\u0018\u00010\u0012J\"\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010YH\u0014J\u0012\u0010Z\u001a\u00020K2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\u0011\u0010]\u001a\u00020KH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010^J\b\u0010_\u001a\u0004\u0018\u00010!R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\'8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u0002038\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010>\u001a\u00020?8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u00020E8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006`"}, d2 = {"Lcom/itx/wvsecurit/ui/view/IncidentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CAPTURE_IMAGE_FULLSIZE_ACTIVITY_REQUEST_CODE", "", "getCAPTURE_IMAGE_FULLSIZE_ACTIVITY_REQUEST_CODE", "()I", "REQUEST_IMAGE_CAPTURE", "getREQUEST_IMAGE_CAPTURE", "addIncidentUseCase", "Lcom/itx/wvsecurit/domain/usecase/AddSegIncidentUseCase;", "getAddIncidentUseCase", "()Lcom/itx/wvsecurit/domain/usecase/AddSegIncidentUseCase;", "setAddIncidentUseCase", "(Lcom/itx/wvsecurit/domain/usecase/AddSegIncidentUseCase;)V", "binding", "Lcom/itx/wvsecurit/databinding/ActivityIncidentBinding;", "imgName", "", "getImgName", "()Ljava/lang/String;", "setImgName", "(Ljava/lang/String;)V", "imgPath", "getImgPath", "setImgPath", "myDialog", "Lcom/itx/wvsecurit/tool/MyDialog;", "getMyDialog", "()Lcom/itx/wvsecurit/tool/MyDialog;", "setMyDialog", "(Lcom/itx/wvsecurit/tool/MyDialog;)V", "outputFileUri", "Landroid/net/Uri;", "getOutputFileUri", "()Landroid/net/Uri;", "setOutputFileUri", "(Landroid/net/Uri;)V", "segIncidentRepository", "Lcom/itx/wvsecurit/data/database/SegIncidentRepository;", "getSegIncidentRepository", "()Lcom/itx/wvsecurit/data/database/SegIncidentRepository;", "setSegIncidentRepository", "(Lcom/itx/wvsecurit/data/database/SegIncidentRepository;)V", "segIncidentTypeRepository", "Lcom/itx/wvsecurit/data/database/SegIncidentTypeRepository;", "getSegIncidentTypeRepository", "()Lcom/itx/wvsecurit/data/database/SegIncidentTypeRepository;", "setSegIncidentTypeRepository", "(Lcom/itx/wvsecurit/data/database/SegIncidentTypeRepository;)V", "segIncidentTypeUseCase", "Lcom/itx/wvsecurit/domain/usecase/GetSegIncidentTypeUseCase;", "getSegIncidentTypeUseCase", "()Lcom/itx/wvsecurit/domain/usecase/GetSegIncidentTypeUseCase;", "setSegIncidentTypeUseCase", "(Lcom/itx/wvsecurit/domain/usecase/GetSegIncidentTypeUseCase;)V", "selectedItemObj", "Lcom/itx/wvsecurit/data/database/entities/SegIncidentTypeEntity;", "getSelectedItemObj", "()Lcom/itx/wvsecurit/data/database/entities/SegIncidentTypeEntity;", "setSelectedItemObj", "(Lcom/itx/wvsecurit/data/database/entities/SegIncidentTypeEntity;)V", "sharedPreferencesRepository", "Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;", "getSharedPreferencesRepository", "()Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;", "setSharedPreferencesRepository", "(Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;)V", "uploadService", "Lcom/itx/wvsecurit/data/network/UploadService;", "getUploadService", "()Lcom/itx/wvsecurit/data/network/UploadService;", "setUploadService", "(Lcom/itx/wvsecurit/data/network/UploadService;)V", "callUploadImageService", "", "file", "Landroid/graphics/Bitmap;", "fileName", "createPartFromString", "Lokhttp3/RequestBody;", "descriptionString", "dispatchTakePictureIntent2", "getAddIncident", "getImagePath", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "save", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setImageUri", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class IncidentActivity extends androidx.appcompat.app.AppCompatActivity {
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private final int CAPTURE_IMAGE_FULLSIZE_ACTIVITY_REQUEST_CODE = 1777;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.database.SegIncidentTypeRepository segIncidentTypeRepository;
    @javax.inject.Inject()
    public com.itx.wvsecurit.domain.usecase.GetSegIncidentTypeUseCase segIncidentTypeUseCase;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.preferences.SharedPreferencesRepository sharedPreferencesRepository;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.database.SegIncidentRepository segIncidentRepository;
    @javax.inject.Inject()
    public com.itx.wvsecurit.tool.MyDialog myDialog;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.network.UploadService uploadService;
    @javax.inject.Inject()
    public com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase addIncidentUseCase;
    private com.itx.wvsecurit.databinding.ActivityIncidentBinding binding;
    public com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity selectedItemObj;
    public java.lang.String imgName;
    public java.lang.String imgPath;
    public android.net.Uri outputFileUri;
    private java.util.HashMap _$_findViewCache;
    
    public IncidentActivity() {
        super();
    }
    
    public final int getREQUEST_IMAGE_CAPTURE() {
        return 0;
    }
    
    public final int getCAPTURE_IMAGE_FULLSIZE_ACTIVITY_REQUEST_CODE() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.SegIncidentTypeRepository getSegIncidentTypeRepository() {
        return null;
    }
    
    public final void setSegIncidentTypeRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.SegIncidentTypeRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.domain.usecase.GetSegIncidentTypeUseCase getSegIncidentTypeUseCase() {
        return null;
    }
    
    public final void setSegIncidentTypeUseCase(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.domain.usecase.GetSegIncidentTypeUseCase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.preferences.SharedPreferencesRepository getSharedPreferencesRepository() {
        return null;
    }
    
    public final void setSharedPreferencesRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.preferences.SharedPreferencesRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.SegIncidentRepository getSegIncidentRepository() {
        return null;
    }
    
    public final void setSegIncidentRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.SegIncidentRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.tool.MyDialog getMyDialog() {
        return null;
    }
    
    public final void setMyDialog(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.tool.MyDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.network.UploadService getUploadService() {
        return null;
    }
    
    public final void setUploadService(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.UploadService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase getAddIncidentUseCase() {
        return null;
    }
    
    public final void setAddIncidentUseCase(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.lang.Object save(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity getSelectedItemObj() {
        return null;
    }
    
    public final void setSelectedItemObj(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity p0) {
    }
    
    private final void getAddIncident() {
    }
    
    private final void dispatchTakePictureIntent2() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImgName() {
        return null;
    }
    
    public final void setImgName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImgPath() {
        return null;
    }
    
    public final void setImgPath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri setImageUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImagePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getOutputFileUri() {
        return null;
    }
    
    public final void setOutputFileUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final okhttp3.RequestBody createPartFromString(java.lang.String descriptionString) {
        return null;
    }
    
    private final void callUploadImageService(android.graphics.Bitmap file, java.lang.String fileName) {
    }
}