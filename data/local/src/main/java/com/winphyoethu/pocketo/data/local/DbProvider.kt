package com.winphyoethu.pocketo.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.Calendar

object DbProvider {

    @Synchronized
    fun create(context: Context) : PocketoDatabase {
        return Room.databaseBuilder(context, PocketoDatabase::class.java, "pocketo")
            .addCallback(object: RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    db.execSQL("INSERT INTO category (category_name,created_at,updated_at) VALUES('Shopping', ${Calendar.getInstance().timeInMillis}, ${Calendar.getInstance().timeInMillis})")
                }
            })
            .build()
    }

}