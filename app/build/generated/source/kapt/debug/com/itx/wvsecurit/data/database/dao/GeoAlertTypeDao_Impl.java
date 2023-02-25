package com.itx.wvsecurit.data.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.itx.wvsecurit.data.database.DateConverter;
import com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GeoAlertTypeDao_Impl implements GeoAlertTypeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GeoAlertTypeEntity> __insertionAdapterOfGeoAlertTypeEntity;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<GeoAlertTypeEntity> __updateAdapterOfGeoAlertTypeEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public GeoAlertTypeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGeoAlertTypeEntity = new EntityInsertionAdapter<GeoAlertTypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `geo_alert_type` (`Id_alert_type`,`action`,`rawprm`,`code`,`name`,`description`,`user_mod`,`date_mod`,`active`,`sync`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GeoAlertTypeEntity value) {
        if (value.getId_alert_type() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_alert_type());
        }
        if (value.getAction() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAction());
        }
        if (value.getRawprm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRawprm());
        }
        if (value.getCode() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescription());
        }
        if (value.getUser_mod() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUser_mod());
        }
        final long _tmp;
        _tmp = __dateConverter.fromDate(value.getDate_mod());
        stmt.bindLong(8, _tmp);
        if (value.getActive() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getActive());
        }
        if (value.getSync() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getSync());
        }
      }
    };
    this.__updateAdapterOfGeoAlertTypeEntity = new EntityDeletionOrUpdateAdapter<GeoAlertTypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `geo_alert_type` SET `Id_alert_type` = ?,`action` = ?,`rawprm` = ?,`code` = ?,`name` = ?,`description` = ?,`user_mod` = ?,`date_mod` = ?,`active` = ?,`sync` = ? WHERE `Id_alert_type` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GeoAlertTypeEntity value) {
        if (value.getId_alert_type() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_alert_type());
        }
        if (value.getAction() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAction());
        }
        if (value.getRawprm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRawprm());
        }
        if (value.getCode() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescription());
        }
        if (value.getUser_mod() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUser_mod());
        }
        final long _tmp;
        _tmp = __dateConverter.fromDate(value.getDate_mod());
        stmt.bindLong(8, _tmp);
        if (value.getActive() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getActive());
        }
        if (value.getSync() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getSync());
        }
        if (value.getId_alert_type() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getId_alert_type());
        }
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE geo_alert_type SET sync = ? WHERE Id_alert_type =?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM geo_alert_type";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<GeoAlertTypeEntity> list,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGeoAlertTypeEntity.insert(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insert(final GeoAlertTypeEntity list,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGeoAlertTypeEntity.insert(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final GeoAlertTypeEntity record,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfGeoAlertTypeEntity.handle(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public void update(final int sync, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, sync);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<GeoAlertTypeEntity>> continuation) {
    final String _sql = "SELECT * FROM geo_alert_type ORDER BY date_mod DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<GeoAlertTypeEntity>>() {
      @Override
      public List<GeoAlertTypeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdAlertType = CursorUtil.getColumnIndexOrThrow(_cursor, "Id_alert_type");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfRawprm = CursorUtil.getColumnIndexOrThrow(_cursor, "rawprm");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfUserMod = CursorUtil.getColumnIndexOrThrow(_cursor, "user_mod");
          final int _cursorIndexOfDateMod = CursorUtil.getColumnIndexOrThrow(_cursor, "date_mod");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfSync = CursorUtil.getColumnIndexOrThrow(_cursor, "sync");
          final List<GeoAlertTypeEntity> _result = new ArrayList<GeoAlertTypeEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GeoAlertTypeEntity _item;
            final Integer _tmpId_alert_type;
            if (_cursor.isNull(_cursorIndexOfIdAlertType)) {
              _tmpId_alert_type = null;
            } else {
              _tmpId_alert_type = _cursor.getInt(_cursorIndexOfIdAlertType);
            }
            final String _tmpAction;
            _tmpAction = _cursor.getString(_cursorIndexOfAction);
            final String _tmpRawprm;
            _tmpRawprm = _cursor.getString(_cursorIndexOfRawprm);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpUser_mod;
            _tmpUser_mod = _cursor.getString(_cursorIndexOfUserMod);
            final Date _tmpDate_mod;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfDateMod);
            _tmpDate_mod = __dateConverter.toDate(_tmp);
            final Integer _tmpActive;
            if (_cursor.isNull(_cursorIndexOfActive)) {
              _tmpActive = null;
            } else {
              _tmpActive = _cursor.getInt(_cursorIndexOfActive);
            }
            final Integer _tmpSync;
            if (_cursor.isNull(_cursorIndexOfSync)) {
              _tmpSync = null;
            } else {
              _tmpSync = _cursor.getInt(_cursorIndexOfSync);
            }
            _item = new GeoAlertTypeEntity(_tmpId_alert_type,_tmpAction,_tmpRawprm,_tmpCode,_tmpName,_tmpDescription,_tmpUser_mod,_tmpDate_mod,_tmpActive,_tmpSync);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllPend(final Continuation<? super List<GeoAlertTypeEntity>> continuation) {
    final String _sql = "SELECT * FROM geo_alert_type WHERE sync = 0 ORDER BY date_mod DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<GeoAlertTypeEntity>>() {
      @Override
      public List<GeoAlertTypeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdAlertType = CursorUtil.getColumnIndexOrThrow(_cursor, "Id_alert_type");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfRawprm = CursorUtil.getColumnIndexOrThrow(_cursor, "rawprm");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfUserMod = CursorUtil.getColumnIndexOrThrow(_cursor, "user_mod");
          final int _cursorIndexOfDateMod = CursorUtil.getColumnIndexOrThrow(_cursor, "date_mod");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfSync = CursorUtil.getColumnIndexOrThrow(_cursor, "sync");
          final List<GeoAlertTypeEntity> _result = new ArrayList<GeoAlertTypeEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GeoAlertTypeEntity _item;
            final Integer _tmpId_alert_type;
            if (_cursor.isNull(_cursorIndexOfIdAlertType)) {
              _tmpId_alert_type = null;
            } else {
              _tmpId_alert_type = _cursor.getInt(_cursorIndexOfIdAlertType);
            }
            final String _tmpAction;
            _tmpAction = _cursor.getString(_cursorIndexOfAction);
            final String _tmpRawprm;
            _tmpRawprm = _cursor.getString(_cursorIndexOfRawprm);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpUser_mod;
            _tmpUser_mod = _cursor.getString(_cursorIndexOfUserMod);
            final Date _tmpDate_mod;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfDateMod);
            _tmpDate_mod = __dateConverter.toDate(_tmp);
            final Integer _tmpActive;
            if (_cursor.isNull(_cursorIndexOfActive)) {
              _tmpActive = null;
            } else {
              _tmpActive = _cursor.getInt(_cursorIndexOfActive);
            }
            final Integer _tmpSync;
            if (_cursor.isNull(_cursorIndexOfSync)) {
              _tmpSync = null;
            } else {
              _tmpSync = _cursor.getInt(_cursorIndexOfSync);
            }
            _item = new GeoAlertTypeEntity(_tmpId_alert_type,_tmpAction,_tmpRawprm,_tmpCode,_tmpName,_tmpDescription,_tmpUser_mod,_tmpDate_mod,_tmpActive,_tmpSync);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }
}
