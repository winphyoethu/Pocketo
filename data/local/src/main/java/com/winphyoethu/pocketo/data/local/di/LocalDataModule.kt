package com.winphyoethu.pocketo.data.local.di

import com.winphyoethu.pocketo.data.common.account.AccountLocalDataSource
import com.winphyoethu.pocketo.data.common.category.CategoryLocalDataSource
import com.winphyoethu.pocketo.data.common.expense.ExpenseLocalDataSource
import com.winphyoethu.pocketo.data.common.usage.MonthlyUsageLocalDataSource
import com.winphyoethu.pocketo.data.local.source.AccountLocalDataSourceImpl
import com.winphyoethu.pocketo.data.local.source.CategoryLocalDataSourceImpl
import com.winphyoethu.pocketo.data.local.source.ExpenseLocalDataSourceImpl
import com.winphyoethu.pocketo.data.local.source.MonthlyUsageLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class LocalDataModule {

    @Binds
    abstract fun bindAccountLocalDataSource(accountLocalDataSourceImpl: AccountLocalDataSourceImpl): AccountLocalDataSource

    @Binds
    abstract fun bindCategoryLocalDataSource(categoryLocalDataSourceImpl: CategoryLocalDataSourceImpl): CategoryLocalDataSource

    @Binds
    abstract fun bindExpenseLocalDataSource(expenseLocalDataSourceImpl: ExpenseLocalDataSourceImpl): ExpenseLocalDataSource

    @Binds
    abstract fun bindMonthlyUsageLocalDataSource(monthlyUsageLocalDataSourceImpl: MonthlyUsageLocalDataSourceImpl): MonthlyUsageLocalDataSource

}