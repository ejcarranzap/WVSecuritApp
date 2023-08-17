package com.itx.wvsecurit.ui.view;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;
import com.itx.wvsecurit.R;
import com.itx.wvsecurit.databinding.ActivityLoginBinding;
import com.itx.wvsecurit.domain.usecase.GetLoginUseCase;
import com.itx.wvsecurit.tool.ManagePermissions;
import com.itx.wvsecurit.tool.MyDialog;
import com.itx.wvsecurit.ui.viewmodel.LoadingViewModel;
import com.itx.wvsecurit.ui.viewmodel.SharedPreferencesViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.*;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u001b\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/itx/wvsecurit/ui/view/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "PermissionsRequestCode", "", "binding", "Lcom/itx/wvsecurit/databinding/ActivityLoginBinding;", "getLoginUseCase", "Lcom/itx/wvsecurit/domain/usecase/GetLoginUseCase;", "getGetLoginUseCase", "()Lcom/itx/wvsecurit/domain/usecase/GetLoginUseCase;", "setGetLoginUseCase", "(Lcom/itx/wvsecurit/domain/usecase/GetLoginUseCase;)V", "managePermissions", "Lcom/itx/wvsecurit/tool/ManagePermissions;", "myDialog", "Lcom/itx/wvsecurit/tool/MyDialog;", "getMyDialog", "()Lcom/itx/wvsecurit/tool/MyDialog;", "setMyDialog", "(Lcom/itx/wvsecurit/tool/MyDialog;)V", "sharedPreferencesViewModel", "Lcom/itx/wvsecurit/ui/viewmodel/SharedPreferencesViewModel;", "getSharedPreferencesViewModel", "()Lcom/itx/wvsecurit/ui/viewmodel/SharedPreferencesViewModel;", "sharedPreferencesViewModel$delegate", "Lkotlin/Lazy;", "login", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.itx.wvsecurit.tool.ManagePermissions managePermissions;
    private final int PermissionsRequestCode = 123;
    @javax.inject.Inject
    public com.itx.wvsecurit.domain.usecase.GetLoginUseCase getLoginUseCase;
    @javax.inject.Inject
    public com.itx.wvsecurit.tool.MyDialog myDialog;
    private com.itx.wvsecurit.databinding.ActivityLoginBinding binding;
    private final kotlin.Lazy sharedPreferencesViewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public LoginActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.itx.wvsecurit.domain.usecase.GetLoginUseCase getGetLoginUseCase() {
        return null;
    }
    
    public final void setGetLoginUseCase(@org.jetbrains.annotations.NotNull
    com.itx.wvsecurit.domain.usecase.GetLoginUseCase p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.itx.wvsecurit.tool.MyDialog getMyDialog() {
        return null;
    }
    
    public final void setMyDialog(@org.jetbrains.annotations.NotNull
    com.itx.wvsecurit.tool.MyDialog p0) {
    }
    
    private final com.itx.wvsecurit.ui.viewmodel.SharedPreferencesViewModel getSharedPreferencesViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}