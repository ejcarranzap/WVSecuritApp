package com.itx.wvsecurit.tool;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.itx.wvsecurit.R;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\rJ&\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0006J)\u0010$\u001a\u00020\r2!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bJ\u000e\u0010%\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010\'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010)\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010*\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R5\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/itx/wvsecurit/tool/MyCustomDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "supportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "cancelText", "", "function", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getFunction", "()Lkotlin/jvm/functions/Function1;", "setFunction", "(Lkotlin/jvm/functions/Function1;)V", "hintText", "mainView", "msg", "okText", "showValue", "", "title", "dismissDialog", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCancelBtnText", "text", "setFunctionDialog", "setMsgDialog", "setOkBtnText", "setShowValueField", "show", "setTitleDialog", "showDialog", "app_debug"})
public final class MyCustomDialogFragment extends androidx.fragment.app.DialogFragment {
    private final androidx.fragment.app.FragmentManager supportFragmentManager = null;
    private android.view.View mainView;
    private java.lang.String title = "";
    private java.lang.String msg = "";
    private java.lang.String hintText = "Value";
    private java.lang.String okText = "OK";
    private java.lang.String cancelText = "CANCEL";
    private boolean showValue = false;
    public kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> function;
    private java.util.HashMap _$_findViewCache;
    
    @javax.inject.Inject
    public MyCustomDialogFragment(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager supportFragmentManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> getFunction() {
        return null;
    }
    
    public final void setFunction(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> p0) {
    }
    
    public final void showDialog() {
    }
    
    public final void dismissDialog() {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    public final void setTitleDialog(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    public final void setMsgDialog(@org.jetbrains.annotations.NotNull
    java.lang.String msg) {
    }
    
    public final void setFunctionDialog(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> function) {
    }
    
    public final void setOkBtnText(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void setCancelBtnText(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void setShowValueField(boolean show) {
    }
}