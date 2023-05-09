package com.itx.wvsecurit.data.network;

import com.itx.common.jcdata.CustomResponse;
import com.itx.wvsecurit.data.constants.Constants;
import com.itx.wvsecurit.data.database.entities.FileEntity;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lcom/itx/wvsecurit/data/network/UploadService;", "", "uploadImages", "Lretrofit2/Call;", "Lcom/itx/common/jcdata/CustomResponse;", "Lcom/itx/wvsecurit/data/database/entities/FileEntity;", "file", "Lokhttp3/MultipartBody$Part;", "app_debug"})
public abstract interface UploadService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "http://45.228.232.227:8080/upload")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<com.itx.common.jcdata.CustomResponse<com.itx.wvsecurit.data.database.entities.FileEntity>> uploadImages(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part file);
}