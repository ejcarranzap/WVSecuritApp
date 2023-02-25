// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.tool;

import android.app.AlertDialog;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MyDialog_Factory implements Factory<MyDialog> {
  private final Provider<AlertDialog> alertDialogProvider;

  public MyDialog_Factory(Provider<AlertDialog> alertDialogProvider) {
    this.alertDialogProvider = alertDialogProvider;
  }

  @Override
  public MyDialog get() {
    return newInstance(alertDialogProvider.get());
  }

  public static MyDialog_Factory create(Provider<AlertDialog> alertDialogProvider) {
    return new MyDialog_Factory(alertDialogProvider);
  }

  public static MyDialog newInstance(AlertDialog alertDialog) {
    return new MyDialog(alertDialog);
  }
}
