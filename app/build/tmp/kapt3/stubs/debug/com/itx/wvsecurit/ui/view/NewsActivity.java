package com.itx.wvsecurit.ui.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.itx.wvsecurit.data.constants.Constants;
import com.itx.wvsecurit.data.database.SegNewsRepository;
import com.itx.wvsecurit.data.database.entities.SegNewsEntity;
import com.itx.wvsecurit.data.network.FileDownloadApiClient;
import com.itx.wvsecurit.data.network.SegNewsApiClient;
import com.itx.wvsecurit.databinding.ActivityNewsBinding;
import com.itx.wvsecurit.tool.AdapterTabPager;
import com.itx.wvsecurit.tool.MyDialog;
import com.itx.wvsecurit.tool.NewsFragment;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.android.synthetic.main.activity_news.*;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import java.io.ByteArrayOutputStream;
import javax.inject.Inject;
import kotlin.properties.Delegates;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020\'J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020.2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,J\u0016\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,J\u0012\u00101\u001a\u00020\'2\b\u00102\u001a\u0004\u0018\u000103H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00064"}, d2 = {"Lcom/itx/wvsecurit/ui/view/NewsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/itx/wvsecurit/databinding/ActivityNewsBinding;", "myDialog", "Lcom/itx/wvsecurit/tool/MyDialog;", "getMyDialog", "()Lcom/itx/wvsecurit/tool/MyDialog;", "setMyDialog", "(Lcom/itx/wvsecurit/tool/MyDialog;)V", "provideFileDownloadApiClient", "Lcom/itx/wvsecurit/data/network/FileDownloadApiClient;", "getProvideFileDownloadApiClient", "()Lcom/itx/wvsecurit/data/network/FileDownloadApiClient;", "setProvideFileDownloadApiClient", "(Lcom/itx/wvsecurit/data/network/FileDownloadApiClient;)V", "provideSegNewsApiClient", "Lcom/itx/wvsecurit/data/network/SegNewsApiClient;", "getProvideSegNewsApiClient", "()Lcom/itx/wvsecurit/data/network/SegNewsApiClient;", "setProvideSegNewsApiClient", "(Lcom/itx/wvsecurit/data/network/SegNewsApiClient;)V", "segNewsRepository", "Lcom/itx/wvsecurit/data/database/SegNewsRepository;", "getSegNewsRepository", "()Lcom/itx/wvsecurit/data/database/SegNewsRepository;", "setSegNewsRepository", "(Lcom/itx/wvsecurit/data/database/SegNewsRepository;)V", "<set-?>", "", "seg_news_type_id", "getSeg_news_type_id", "()I", "setSeg_news_type_id", "(I)V", "seg_news_type_id$delegate", "Lkotlin/properties/ReadWriteProperty;", "fillTabs", "", "generateImageView", "Landroid/widget/ImageView;", "id", "url", "", "generateWebView", "Landroid/webkit/WebView;", "generateWebViewVideo", "Landroid/widget/VideoView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class NewsActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.itx.wvsecurit.databinding.ActivityNewsBinding binding;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.database.SegNewsRepository segNewsRepository;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.network.SegNewsApiClient provideSegNewsApiClient;
    @javax.inject.Inject()
    public com.itx.wvsecurit.tool.MyDialog myDialog;
    @javax.inject.Inject()
    public com.itx.wvsecurit.data.network.FileDownloadApiClient provideFileDownloadApiClient;
    private final kotlin.properties.ReadWriteProperty seg_news_type_id$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public NewsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.SegNewsRepository getSegNewsRepository() {
        return null;
    }
    
    public final void setSegNewsRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.SegNewsRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.network.SegNewsApiClient getProvideSegNewsApiClient() {
        return null;
    }
    
    public final void setProvideSegNewsApiClient(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.SegNewsApiClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.tool.MyDialog getMyDialog() {
        return null;
    }
    
    public final void setMyDialog(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.tool.MyDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.network.FileDownloadApiClient getProvideFileDownloadApiClient() {
        return null;
    }
    
    public final void setProvideFileDownloadApiClient(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.FileDownloadApiClient p0) {
    }
    
    private final int getSeg_news_type_id() {
        return 0;
    }
    
    private final void setSeg_news_type_id(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView generateImageView(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.VideoView generateWebViewVideo(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.webkit.WebView generateWebView(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    public final void fillTabs() {
    }
}