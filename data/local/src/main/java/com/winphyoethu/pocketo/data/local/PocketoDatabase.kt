package com.winphyoethu.pocketo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.winphyoethu.pocketo.data.local.dao.AccountDao
import com.winphyoethu.pocketo.data.local.dao.CategoryDao
import com.winphyoethu.pocketo.data.local.dao.ExpenseDao
import com.winphyoethu.pocketo.data.local.dao.MonthlyUsageDao
import com.winphyoethu.pocketo.data.local.entity.AccountEntity
import com.winphyoethu.pocketo.data.local.entity.CategoryEntity
import com.winphyoethu.pocketo.data.local.entity.ExpenseEntity

@Database(
    entities = [AccountEntity::class, CategoryEntity::class, ExpenseEntity::class],
    version = 1,
    exportSchema = true
)
abstract class PocketoDatabase() : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    abstract fun categoryDao(): CategoryDao

    abstract fun expenseDao(): ExpenseDao

    abstract fun monthlyUsageDao(): MonthlyUsageDao

}