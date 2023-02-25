package com.itx.wvsecurit.tool;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\u0006\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/itx/wvsecurit/tool/ManagePermissions;", "", "activity", "Landroid/app/Activity;", "list", "", "", "code", "", "(Landroid/app/Activity;Ljava/util/List;I)V", "getActivity", "()Landroid/app/Activity;", "getCode", "()I", "getList", "()Ljava/util/List;", "checkPermissions", "", "deniedPermission", "isPermissionsGranted", "processPermissionsResult", "", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "requestPermissions", "showAlert", "app_debug"})
public final class ManagePermissions {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> list = null;
    private final int code = 0;
    
    public ManagePermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list, int code) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getList() {
        return null;
    }
    
    public final int getCode() {
        return 0;
    }
    
    public final void checkPermissions() {
    }
    
    private final int isPermissionsGranted() {
        return 0;
    }
    
    private final java.lang.String deniedPermission() {
        return null;
    }
    
    private final void showAlert() {
    }
    
    private final void requestPermissions() {
    }
    
    public final boolean processPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
        return false;
    }
}