package com.itx.wvsecurit.data.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;
import java.util.*;

@androidx.room.Entity(tableName = "geo_location_alert")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010)\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010*\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u0092\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\u0003H\u00d6\u0001J\t\u00104\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017\u00a8\u00065"}, d2 = {"Lcom/itx/wvsecurit/data/database/entities/GeoLocationAlertEntity;", "", "Id_geo_location_alert", "", "action", "", "rawprm", "Id_alert_type", "latitude", "", "longitude", "description", "user_mod", "date_mod", "Ljava/util/Date;", "active", "sync", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId_alert_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId_geo_location_alert", "getAction", "()Ljava/lang/String;", "getActive", "getDate_mod", "()Ljava/util/Date;", "getDescription", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "getRawprm", "getSync", "getUser_mod", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/itx/wvsecurit/data/database/entities/GeoLocationAlertEntity;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class GeoLocationAlertEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "Id_geo_location_alert")
    @androidx.room.PrimaryKey()
    @com.google.gson.annotations.SerializedName(value = "Id_geo_location_alert")
    private final java.lang.Integer Id_geo_location_alert = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "action")
    @com.google.gson.annotations.SerializedName(value = "action")
    private final java.lang.String action = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "rawprm")
    @com.google.gson.annotations.SerializedName(value = "rawprm")
    private final java.lang.String rawprm = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "Id_alert_type")
    @com.google.gson.annotations.SerializedName(value = "Id_alert_type")
    private final java.lang.Integer Id_alert_type = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "latitude")
    @com.google.gson.annotations.SerializedName(value = "latitude")
    private final java.lang.Double latitude = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "longitude")
    @com.google.gson.annotations.SerializedName(value = "longitude")
    private final java.lang.Double longitude = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "description")
    @com.google.gson.annotations.SerializedName(value = "description")
    private final java.lang.String description = null;
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
    public final com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer Id_geo_location_alert, @org.jetbrains.annotations.Nullable()
    java.lang.String action, @org.jetbrains.annotations.Nullable()
    java.lang.String rawprm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Id_alert_type, @org.jetbrains.annotations.Nullable()
    java.lang.Double latitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double longitude, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
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
    
    public GeoLocationAlertEntity() {
        super();
    }
    
    public GeoLocationAlertEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer Id_geo_location_alert, @org.jetbrains.annotations.Nullable()
    java.lang.String action, @org.jetbrains.annotations.Nullable()
    java.lang.String rawprm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Id_alert_type, @org.jetbrains.annotations.Nullable()
    java.lang.Double latitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double longitude, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
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
    public final java.lang.Integer getId_geo_location_alert() {
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
    public final java.lang.Integer getId_alert_type() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLatitude() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLongitude() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUser_mod() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getDate_mod() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getActive() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSync() {
        return null;
    }
}