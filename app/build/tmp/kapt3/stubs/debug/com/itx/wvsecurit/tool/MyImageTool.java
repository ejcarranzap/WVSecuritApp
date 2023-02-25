package com.itx.wvsecurit.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import java.io.*;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/itx/wvsecurit/tool/MyImageTool;", "", "()V", "Companion", "app_debug"})
public final class MyImageTool {
    @org.jetbrains.annotations.NotNull()
    public static final com.itx.wvsecurit.tool.MyImageTool.Companion Companion = null;
    public static android.content.Context context;
    
    public MyImageTool() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\"\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/itx/wvsecurit/tool/MyImageTool$Companion;", "", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "buildImageBodyPart", "Lokhttp3/MultipartBody$Part;", "fileName", "", "bitmap", "Landroid/graphics/Bitmap;", "convertBitmapToFile", "Ljava/io/File;", "decodeSampledBitmapFromFile", "path", "reqWidth", "", "reqHeight", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        public final void setContext(@org.jetbrains.annotations.NotNull()
        android.content.Context p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final okhttp3.MultipartBody.Part buildImageBodyPart(@org.jetbrains.annotations.NotNull()
        java.lang.String fileName, @org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap bitmap) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.io.File convertBitmapToFile(@org.jetbrains.annotations.NotNull()
        java.lang.String fileName, @org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap bitmap) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.graphics.Bitmap decodeSampledBitmapFromFile(@org.jetbrains.annotations.Nullable()
        java.lang.String path, int reqWidth, int reqHeight) {
            return null;
        }
    }
}