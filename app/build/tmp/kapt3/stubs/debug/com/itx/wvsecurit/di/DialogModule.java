package com.itx.wvsecurit.di;

import android.app.AlertDialog;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.itx.wvsecurit.R;
import com.itx.wvsecurit.tool.MyCustomDialogFragment;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;
import javax.inject.Inject;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ActivityComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/itx/wvsecurit/di/DialogModule;", "", "()V", "provideMyAlertDialog", "Landroid/app/AlertDialog;", "activity", "Landroid/content/Context;", "provideMyCustomDialogFragment", "Lcom/itx/wvsecurit/tool/MyCustomDialogFragment;", "app_debug"})
@dagger.Module()
public final class DialogModule {
    
    @javax.inject.Inject()
    public DialogModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.app.AlertDialog provideMyAlertDialog(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ActivityContext()
    android.content.Context activity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.itx.wvsecurit.tool.MyCustomDialogFragment provideMyCustomDialogFragment(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ActivityContext()
    android.content.Context activity) {
        return null;
    }
}