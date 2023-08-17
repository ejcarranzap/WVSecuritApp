package com.itx.wvsecurit.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.itx.wvsecurit.data.database.dao.*;
import com.itx.wvsecurit.data.database.entities.*;

@androidx.room.TypeConverters(value = {com.itx.wvsecurit.data.database.DateConverter.class})
@androidx.room.Database(entities = {com.itx.wvsecurit.data.database.entities.GeoLocationEntity.class, com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity.class, com.itx.wvsecurit.data.database.entities.SegIncidentEntity.class, com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity.class, com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity.class, com.itx.wvsecurit.data.database.entities.SegNewsEntity.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/itx/wvsecurit/data/database/WvSecuritDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getGeoAlertTypeDao", "Lcom/itx/wvsecurit/data/database/dao/GeoAlertTypeDao;", "getGeoLocationAlertDao", "Lcom/itx/wvsecurit/data/database/dao/GeoLocationAlertDao;", "getGeoLocationDao", "Lcom/itx/wvsecurit/data/database/dao/GeoLocationDao;", "getSegIncidentDao", "Lcom/itx/wvsecurit/data/database/dao/SegIncidentDao;", "getSegIncidentTypeDao", "Lcom/itx/wvsecurit/data/database/dao/SegIncidentTypeDao;", "getSegNewsDao", "Lcom/itx/wvsecurit/data/database/dao/SegNewsDao;", "app_debug"})
public abstract class WvSecuritDatabase extends androidx.room.RoomDatabase {
    
    public WvSecuritDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.itx.wvsecurit.data.database.dao.GeoLocationDao getGeoLocationDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.itx.wvsecurit.data.database.dao.SegIncidentTypeDao getSegIncidentTypeDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.itx.wvsecurit.data.database.dao.SegIncidentDao getSegIncidentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.itx.wvsecurit.data.database.dao.GeoAlertTypeDao getGeoAlertTypeDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao getGeoLocationAlertDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.itx.wvsecurit.data.database.dao.SegNewsDao getSegNewsDao();
}