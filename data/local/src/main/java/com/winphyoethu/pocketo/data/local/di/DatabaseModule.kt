package com.winphyoethu.pocketo.data.local.di

import android.content.Context
import com.winphyoethu.pocketo.data.local.DbProvider
import com.winphyoethu.pocketo.data.local.PocketoDatabase
import com.winphyoethu.pocketo.data.local.dao.AccountDao
import com.winphyoethu.pocketo.data.local.dao.CategoryDao
import com.winphyoethu.pocketo.data.local.dao.ExpenseDao
import com.winphyoethu.pocketo.data.local.dao.MonthlyUsageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providePocketoDatabase(@ApplicationContext context: Context): PocketoDatabase =
        DbProvider.create(context)

    @Provides
    fun provideAccountDao(pocketoDatabase: PocketoDatabase): AccountDao =
        pocketoDatabase.accountDao()

    @Provides
    fun provideCategoryDao(pocketoDatabase: PocketoDatabase): CategoryDao =
        pocketoDatabase.categoryDao()

    @Provides
    fun provideExpenseDao(pocketoDatabase: PocketoDatabase): ExpenseDao =
        pocketoDatabase.expenseDao()

    @Provides
    fun provideMonthlyUsageDao(pocketoDatabase: PocketoDatabase): MonthlyUsageDao =
        pocketoDatabase.monthlyUsageDao()

}