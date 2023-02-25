package com.itx.wvsecurit.di

import android.content.Context
import androidx.room.Room
import com.itx.wvsecurit.data.database.WvSecuritDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DATABASE_NAME = "wvsecurit_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, WvSecuritDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideGeoLocationDao(db:WvSecuritDatabase) = db.getGeoLocationDao()

    @Singleton
    @Provides
    fun provideSegIncidentTypeDao(db:WvSecuritDatabase) = db.getSegIncidentTypeDao()

    @Singleton
    @Provides
    fun provideGeoAlertTypeDao(db:WvSecuritDatabase) = db.getGeoAlertTypeDao()

    @Singleton
    @Provides
    fun provideGeoLocationAlertDao(db:WvSecuritDatabase) = db.getGeoLocationAlertDao()

    @Singleton
    @Provides
    fun provideSegIncidentDao(db:WvSecuritDatabase) = db.getSegIncidentDao()

    @Singleton
    @Provides
    fun provideSegNewsDao(db:WvSecuritDatabase) = db.getSegNewsDao()
}