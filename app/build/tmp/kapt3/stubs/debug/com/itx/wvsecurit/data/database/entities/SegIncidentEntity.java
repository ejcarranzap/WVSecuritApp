package com.itx.wvsecurit.data.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;
import java.util.*;

@androidx.room.Entity(tableName = "seg_incident")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u0010\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u0086\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001J\t\u0010.\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015\u00a8\u0006/"}, d2 = {"Lcom/itx/wvsecurit/data/database/entities/SegIncidentEntity;", "", "Id_incident", "", "action", "", "rawprm", "Id_incident_type", "description", "image1", "user_mod", "date_mod", "Ljava/util/Date;", "active", "sync", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId_incident", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId_incident_type", "getAction", "()Ljava/lang/String;", "getActive", "getDate_mod", "()Ljava/util/Date;", "getDescription", "getImage1", "getRawprm", "getSync", "getUser_mod", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/itx/wvsecurit/data/database/entities/SegIncidentEntity;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class SegIncidentEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "Id_incident")
    @androidx.room.PrimaryKey()
    @com.google.gson.annotations.SerializedName(value = "Id_incident")
    private final java.lang.Integer Id_incident = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "action")
    @com.google.gson.annotations.SerializedName(value = "action")
    private final java.lang.String action = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "rawprm")
    @com.google.gson.annotations.SerializedName(value = "rawprm")
    private final java.lang.String rawprm = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "Id_incident_type")
    @com.google.gson.annotations.SerializedName(value = "Id_incident_type")
    private final java.lang.Integer Id_incident_type = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "description")
    @com.google.gson.annotations.SerializedName(value = "description")
    private final java.lang.String description = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "image1")
    @com.google.gson.annotations.SerializedName(value = "image1")
    private final java.lang.String image1 = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "user_mod")
    @com.google.gson.annotations.SerializedName(value = "user_mod")
    private final java.lang.String user_mod = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "date_mod")
    @com.google.gson.annotations.SerializedName(value = "date_mod")
    private final java.util.Date date_mod = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "active")
    @com.google.gson.annotations.SerializedName(value = "active")
    private final java.lang.Integer active = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "sync")
    @com.google.gson.annotations.SerializedName(value = "sync")
    private final java.lang.Integer sync = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.itx.wvsecurit.data.database.entities.SegIncidentEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer Id_incident, @org.jetbrains.annotations.Nullable()
    java.lang.String action, @org.jetbrains.annotations.Nullable()
    java.lang.String rawprm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Id_incident_type, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String image1, @org.jetbrains.annotations.Nullable()
    java.lang.String user_mod, @org.jetbrains.annotations.Nullable()
    java.util.Date date_mod, @org.jetbrains.annotations.Nullable()
    java.lang.Integer active, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sync) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public SegIncidentEntity() {
        super();
    }
    
    public SegIncidentEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer Id_incident, @org.jetbrains.annotations.Nullable()
    java.lang.String action, @org.jetbrains.annotations.Nullable()
    java.lang.String rawprm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Id_incident_type, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String image1, @org.jetbrains.annotations.Nullable()
    java.lang.String user_mod, @org.jetbrains.annotations.Nullable()
    java.util.Date date_mod, @org.jetbrains.annotations.Nullable()
    java.lang.Integer active, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sync) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId_incident() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAction() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRawprm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId_incident_type() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImage1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUser_mod() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getDate_mod() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getActive() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSync() {
        return null;
    }
}