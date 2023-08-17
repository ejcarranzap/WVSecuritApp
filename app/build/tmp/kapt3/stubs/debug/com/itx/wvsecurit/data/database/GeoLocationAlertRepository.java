package com.itx.wvsecurit.data.database;

import com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao;
import com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/itx/wvsecurit/data/database/GeoLocationAlertRepository;", "", "dao", "Lcom/itx/wvsecurit/data/database/dao/GeoLocationAlertDao;", "(Lcom/itx/wvsecurit/data/database/dao/GeoLocationAlertDao;)V", "getAllGeoLocation", "", "Lcom/itx/wvsecurit/data/database/entities/GeoLocationAlertEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllGeoLocationPend", "insertGeoLocation", "", "geoLocationEntity", "(Lcom/itx/wvsecurit/data/database/entities/GeoLocationAlertEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGeoLocationSync", "sync", "", "id", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GeoLocationAlertRepository {
    private final com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao dao = null;
    
    @javax.inject.Inject
    public GeoLocationAlertRepository(@org.jetbrains.annotations.NotNull
    com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllGeoLocation(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllGeoLocationPend(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertGeoLocation(@org.jetbrains.annotations.NotNull
    com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity geoLocationEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateGeoLocationSync(int sync, int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}