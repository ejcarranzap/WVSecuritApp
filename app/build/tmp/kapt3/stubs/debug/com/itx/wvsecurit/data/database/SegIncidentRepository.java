package com.itx.wvsecurit.data.database;

import com.itx.wvsecurit.data.database.dao.SegIncidentDao;
import com.itx.wvsecurit.data.database.entities.SegIncidentEntity;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/itx/wvsecurit/data/database/SegIncidentRepository;", "", "segIncidentDao", "Lcom/itx/wvsecurit/data/database/dao/SegIncidentDao;", "(Lcom/itx/wvsecurit/data/database/dao/SegIncidentDao;)V", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "Lcom/itx/wvsecurit/data/database/entities/SegIncidentEntity;", "getAllPend", "insert", "addIncidentEntity", "(Lcom/itx/wvsecurit/data/database/entities/SegIncidentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSync", "sync", "", "id", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SegIncidentRepository {
    private final com.itx.wvsecurit.data.database.dao.SegIncidentDao segIncidentDao = null;
    
    @javax.inject.Inject()
    public SegIncidentRepository(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.dao.SegIncidentDao segIncidentDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.itx.wvsecurit.data.database.entities.SegIncidentEntity>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllPend(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.itx.wvsecurit.data.database.entities.SegIncidentEntity>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.entities.SegIncidentEntity addIncidentEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateSync(int sync, int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}