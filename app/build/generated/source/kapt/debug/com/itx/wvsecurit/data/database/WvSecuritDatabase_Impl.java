package com.itx.wvsecurit.data.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.itx.wvsecurit.data.database.dao.GeoAlertTypeDao;
import com.itx.wvsecurit.data.database.dao.GeoAlertTypeDao_Impl;
import com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao;
import com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao_Impl;
import com.itx.wvsecurit.data.database.dao.GeoLocationDao;
import com.itx.wvsecurit.data.database.dao.GeoLocationDao_Impl;
import com.itx.wvsecurit.data.database.dao.SegIncidentDao;
import com.itx.wvsecurit.data.database.dao.SegIncidentDao_Impl;
import com.itx.wvsecurit.data.database.dao.SegIncidentTypeDao;
import com.itx.wvsecurit.data.database.dao.SegIncidentTypeDao_Impl;
import com.itx.wvsecurit.data.database.dao.SegNewsDao;
import com.itx.wvsecurit.data.database.dao.SegNewsDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WvSecuritDatabase_Impl extends WvSecuritDatabase {
  private volatile GeoLocationDao _geoLocationDao;

  private volatile SegIncidentTypeDao _segIncidentTypeDao;

  private volatile SegIncidentDao _segIncidentDao;

  private volatile GeoAlertTypeDao _geoAlertTypeDao;

  private volatile GeoLocationAlertDao _geoLocationAlertDao;

  private volatile SegNewsDao _segNewsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `geo_location` (`Id_geo_location` INTEGER, `action` TEXT, `rawprm` TEXT, `latitude` REAL, `longitude` REAL, `description` TEXT, `user_mod` TEXT, `date_mod` INTEGER, `active` INTEGER, `sync` INTEGER, PRIMARY KEY(`Id_geo_location`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `seg_incident_type` (`Id_incident_type` INTEGER, `action` TEXT, `rawprm` TEXT, `Id_incident_group` INTEGER, `code` TEXT, `name` TEXT, `description` TEXT, `user_mod` TEXT, `date_mod` INTEGER, `active` INTEGER, `sync` INTEGER, PRIMARY KEY(`Id_incident_type`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `seg_incident` (`Id_incident` INTEGER, `action` TEXT, `rawprm` TEXT, `Id_incident_type` INTEGER, `description` TEXT, `image1` TEXT, `user_mod` TEXT, `date_mod` INTEGER, `active` INTEGER, `sync` INTEGER, PRIMARY KEY(`Id_incident`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `geo_alert_type` (`Id_alert_type` INTEGER, `action` TEXT, `rawprm` TEXT, `code` TEXT, `name` TEXT, `description` TEXT, `user_mod` TEXT, `date_mod` INTEGER, `active` INTEGER, `sync` INTEGER, PRIMARY KEY(`Id_alert_type`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `geo_location_alert` (`Id_geo_location_alert` INTEGER, `action` TEXT, `rawprm` TEXT, `Id_alert_type` INTEGER, `latitude` REAL, `longitude` REAL, `description` TEXT, `user_mod` TEXT, `date_mod` INTEGER, `active` INTEGER, `sync` INTEGER, PRIMARY KEY(`Id_geo_location_alert`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `seg_news` (`Id_news` INTEGER, `action` TEXT, `rawprm` TEXT, `description` TEXT, `image1` TEXT, `user_mod` TEXT, `date_mod` INTEGER, `active` INTEGER, `sync` INTEGER, `Id_news_type` INTEGER, PRIMARY KEY(`Id_news`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '83804fceed496c21df7c1d8c46f5c9ab')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `geo_location`");
        _db.execSQL("DROP TABLE IF EXISTS `seg_incident_type`");
        _db.execSQL("DROP TABLE IF EXISTS `seg_incident`");
        _db.execSQL("DROP TABLE IF EXISTS `geo_alert_type`");
        _db.execSQL("DROP TABLE IF EXISTS `geo_location_alert`");
        _db.execSQL("DROP TABLE IF EXISTS `seg_news`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsGeoLocation = new HashMap<String, TableInfo.Column>(10);
        _columnsGeoLocation.put("Id_geo_location", new TableInfo.Column("Id_geo_location", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("rawprm", new TableInfo.Column("rawprm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("user_mod", new TableInfo.Column("user_mod", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("date_mod", new TableInfo.Column("date_mod", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("active", new TableInfo.Column("active", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocation.put("sync", new TableInfo.Column("sync", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGeoLocation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGeoLocation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGeoLocation = new TableInfo("geo_location", _columnsGeoLocation, _foreignKeysGeoLocation, _indicesGeoLocation);
        final TableInfo _existingGeoLocation = TableInfo.read(_db, "geo_location");
        if (! _infoGeoLocation.equals(_existingGeoLocation)) {
          return new RoomOpenHelper.ValidationResult(false, "geo_location(com.itx.wvsecurit.data.database.entities.GeoLocationEntity).\n"
                  + " Expected:\n" + _infoGeoLocation + "\n"
                  + " Found:\n" + _existingGeoLocation);
        }
        final HashMap<String, TableInfo.Column> _columnsSegIncidentType = new HashMap<String, TableInfo.Column>(11);
        _columnsSegIncidentType.put("Id_incident_type", new TableInfo.Column("Id_incident_type", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("rawprm", new TableInfo.Column("rawprm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("Id_incident_group", new TableInfo.Column("Id_incident_group", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("code", new TableInfo.Column("code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("user_mod", new TableInfo.Column("user_mod", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("date_mod", new TableInfo.Column("date_mod", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("active", new TableInfo.Column("active", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncidentType.put("sync", new TableInfo.Column("sync", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSegIncidentType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSegIncidentType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSegIncidentType = new TableInfo("seg_incident_type", _columnsSegIncidentType, _foreignKeysSegIncidentType, _indicesSegIncidentType);
        final TableInfo _existingSegIncidentType = TableInfo.read(_db, "seg_incident_type");
        if (! _infoSegIncidentType.equals(_existingSegIncidentType)) {
          return new RoomOpenHelper.ValidationResult(false, "seg_incident_type(com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity).\n"
                  + " Expected:\n" + _infoSegIncidentType + "\n"
                  + " Found:\n" + _existingSegIncidentType);
        }
        final HashMap<String, TableInfo.Column> _columnsSegIncident = new HashMap<String, TableInfo.Column>(10);
        _columnsSegIncident.put("Id_incident", new TableInfo.Column("Id_incident", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("rawprm", new TableInfo.Column("rawprm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("Id_incident_type", new TableInfo.Column("Id_incident_type", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("image1", new TableInfo.Column("image1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("user_mod", new TableInfo.Column("user_mod", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("date_mod", new TableInfo.Column("date_mod", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("active", new TableInfo.Column("active", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegIncident.put("sync", new TableInfo.Column("sync", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSegIncident = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSegIncident = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSegIncident = new TableInfo("seg_incident", _columnsSegIncident, _foreignKeysSegIncident, _indicesSegIncident);
        final TableInfo _existingSegIncident = TableInfo.read(_db, "seg_incident");
        if (! _infoSegIncident.equals(_existingSegIncident)) {
          return new RoomOpenHelper.ValidationResult(false, "seg_incident(com.itx.wvsecurit.data.database.entities.SegIncidentEntity).\n"
                  + " Expected:\n" + _infoSegIncident + "\n"
                  + " Found:\n" + _existingSegIncident);
        }
        final HashMap<String, TableInfo.Column> _columnsGeoAlertType = new HashMap<String, TableInfo.Column>(10);
        _columnsGeoAlertType.put("Id_alert_type", new TableInfo.Column("Id_alert_type", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("rawprm", new TableInfo.Column("rawprm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("code", new TableInfo.Column("code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("user_mod", new TableInfo.Column("user_mod", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("date_mod", new TableInfo.Column("date_mod", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("active", new TableInfo.Column("active", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoAlertType.put("sync", new TableInfo.Column("sync", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGeoAlertType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGeoAlertType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGeoAlertType = new TableInfo("geo_alert_type", _columnsGeoAlertType, _foreignKeysGeoAlertType, _indicesGeoAlertType);
        final TableInfo _existingGeoAlertType = TableInfo.read(_db, "geo_alert_type");
        if (! _infoGeoAlertType.equals(_existingGeoAlertType)) {
          return new RoomOpenHelper.ValidationResult(false, "geo_alert_type(com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity).\n"
                  + " Expected:\n" + _infoGeoAlertType + "\n"
                  + " Found:\n" + _existingGeoAlertType);
        }
        final HashMap<String, TableInfo.Column> _columnsGeoLocationAlert = new HashMap<String, TableInfo.Column>(11);
        _columnsGeoLocationAlert.put("Id_geo_location_alert", new TableInfo.Column("Id_geo_location_alert", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("rawprm", new TableInfo.Column("rawprm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("Id_alert_type", new TableInfo.Column("Id_alert_type", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("user_mod", new TableInfo.Column("user_mod", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("date_mod", new TableInfo.Column("date_mod", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("active", new TableInfo.Column("active", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeoLocationAlert.put("sync", new TableInfo.Column("sync", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGeoLocationAlert = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGeoLocationAlert = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGeoLocationAlert = new TableInfo("geo_location_alert", _columnsGeoLocationAlert, _foreignKeysGeoLocationAlert, _indicesGeoLocationAlert);
        final TableInfo _existingGeoLocationAlert = TableInfo.read(_db, "geo_location_alert");
        if (! _infoGeoLocationAlert.equals(_existingGeoLocationAlert)) {
          return new RoomOpenHelper.ValidationResult(false, "geo_location_alert(com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity).\n"
                  + " Expected:\n" + _infoGeoLocationAlert + "\n"
                  + " Found:\n" + _existingGeoLocationAlert);
        }
        final HashMap<String, TableInfo.Column> _columnsSegNews = new HashMap<String, TableInfo.Column>(10);
        _columnsSegNews.put("Id_news", new TableInfo.Column("Id_news", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("rawprm", new TableInfo.Column("rawprm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("image1", new TableInfo.Column("image1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("user_mod", new TableInfo.Column("user_mod", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("date_mod", new TableInfo.Column("date_mod", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("active", new TableInfo.Column("active", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("sync", new TableInfo.Column("sync", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSegNews.put("Id_news_type", new TableInfo.Column("Id_news_type", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSegNews = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSegNews = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSegNews = new TableInfo("seg_news", _columnsSegNews, _foreignKeysSegNews, _indicesSegNews);
        final TableInfo _existingSegNews = TableInfo.read(_db, "seg_news");
        if (! _infoSegNews.equals(_existingSegNews)) {
          return new RoomOpenHelper.ValidationResult(false, "seg_news(com.itx.wvsecurit.data.database.entities.SegNewsEntity).\n"
                  + " Expected:\n" + _infoSegNews + "\n"
                  + " Found:\n" + _existingSegNews);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "83804fceed496c21df7c1d8c46f5c9ab", "21ae6e09f96bd778c506f3afada66fd7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "geo_location","seg_incident_type","seg_incident","geo_alert_type","geo_location_alert","seg_news");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `geo_location`");
      _db.execSQL("DELETE FROM `seg_incident_type`");
      _db.execSQL("DELETE FROM `seg_incident`");
      _db.execSQL("DELETE FROM `geo_alert_type`");
      _db.execSQL("DELETE FROM `geo_location_alert`");
      _db.execSQL("DELETE FROM `seg_news`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public GeoLocationDao getGeoLocationDao() {
    if (_geoLocationDao != null) {
      return _geoLocationDao;
    } else {
      synchronized(this) {
        if(_geoLocationDao == null) {
          _geoLocationDao = new GeoLocationDao_Impl(this);
        }
        return _geoLocationDao;
      }
    }
  }

  @Override
  public SegIncidentTypeDao getSegIncidentTypeDao() {
    if (_segIncidentTypeDao != null) {
      return _segIncidentTypeDao;
    } else {
      synchronized(this) {
        if(_segIncidentTypeDao == null) {
          _segIncidentTypeDao = new SegIncidentTypeDao_Impl(this);
        }
        return _segIncidentTypeDao;
      }
    }
  }

  @Override
  public SegIncidentDao getSegIncidentDao() {
    if (_segIncidentDao != null) {
      return _segIncidentDao;
    } else {
      synchronized(this) {
        if(_segIncidentDao == null) {
          _segIncidentDao = new SegIncidentDao_Impl(this);
        }
        return _segIncidentDao;
      }
    }
  }

  @Override
  public GeoAlertTypeDao getGeoAlertTypeDao() {
    if (_geoAlertTypeDao != null) {
      return _geoAlertTypeDao;
    } else {
      synchronized(this) {
        if(_geoAlertTypeDao == null) {
          _geoAlertTypeDao = new GeoAlertTypeDao_Impl(this);
        }
        return _geoAlertTypeDao;
      }
    }
  }

  @Override
  public GeoLocationAlertDao getGeoLocationAlertDao() {
    if (_geoLocationAlertDao != null) {
      return _geoLocationAlertDao;
    } else {
      synchronized(this) {
        if(_geoLocationAlertDao == null) {
          _geoLocationAlertDao = new GeoLocationAlertDao_Impl(this);
        }
        return _geoLocationAlertDao;
      }
    }
  }

  @Override
  public SegNewsDao getSegNewsDao() {
    if (_segNewsDao != null) {
      return _segNewsDao;
    } else {
      synchronized(this) {
        if(_segNewsDao == null) {
          _segNewsDao = new SegNewsDao_Impl(this);
        }
        return _segNewsDao;
      }
    }
  }
}
