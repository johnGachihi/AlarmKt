package com.johngachihi.alarmkt.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.johngachihi.alarmkt.data.db.converters.RoomConverters
import com.johngachihi.alarmkt.data.db.daos.AlarmDao
import com.johngachihi.alarmkt.data.db.entities.Alarm

@Database(entities = [Alarm::class], version = 1)
@TypeConverters(RoomConverters::class)
abstract class AlarmsDatabase : RoomDatabase() {

    abstract fun alarmDao(): AlarmDao

    companion object {
        @Volatile
        private var INSTANCE: AlarmsDatabase? = null

        fun getDatabase(context: Context): AlarmsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    AlarmsDatabase::class.java, "alarms_db")
                    .build()
                INSTANCE = instance
                instance
            }


        }
    }
}