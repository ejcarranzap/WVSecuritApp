package com.itx.common.jcdata;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000e\u0010\u001d\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJB\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00028\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010#\u001a\u00020\u0004H\u00d6\u0001J\t\u0010$\u001a\u00020\u0006H\u00d6\u0001R \u0010\b\u001a\u00028\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/itx/common/jcdata/CustomResponse;", "T", "", "statusCode", "", "msg", "", "success", "data", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getStatusCode", "()Ljava/lang/Integer;", "setStatusCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSuccess", "setSuccess", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/itx/common/jcdata/CustomResponse;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class CustomResponse<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "code")
    private java.lang.Integer statusCode;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "msg")
    private java.lang.String msg;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "success")
    private java.lang.String success;
    @com.google.gson.annotations.SerializedName(value = "data")
    private T data;
    
    @org.jetbrains.annotations.NotNull
    public final com.itx.common.jcdata.CustomResponse<T> copy(@org.jetbrains.annotations.Nullable
    java.lang.Integer statusCode, @org.jetbrains.annotations.Nullable
    java.lang.String msg, @org.jetbrains.annotations.Nullable
    java.lang.String success, T data) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public CustomResponse(@org.jetbrains.annotations.Nullable
    java.lang.Integer statusCode, @org.jetbrains.annotations.Nullable
    java.lang.String msg, @org.jetbrains.annotations.Nullable
    java.lang.String success, T data) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getStatusCode() {
        return null;
    }
    
    public final void setStatusCode(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMsg() {
        return null;
    }
    
    public final void setMsg(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSuccess() {
        return null;
    }
    
    public final void setSuccess(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final T component4() {
        return null;
    }
    
    public final T getData() {
        return null;
    }
    
    public final void setData(T p0) {
    }
}