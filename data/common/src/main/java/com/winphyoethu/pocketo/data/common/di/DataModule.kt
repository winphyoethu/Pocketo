package com.winphyoethu.pocketo.data.common.di

import com.winphyoethu.pocketo.data.common.account.AccountRepositoryImpl
import com.winphyoethu.pocketo.data.common.category.CategoryRepositoryImpl
import com.winphyoethu.pocketo.data.common.expense.ExpenseRepositoryImpl
import com.winphyoethu.pocketo.data.common.usage.MonthlyUsageRepositoryImpl
import com.winphyoethu.pocketo.domain.account.AccountRepository
import com.winphyoethu.pocketo.domain.category.CategoryRepository
import com.winphyoethu.pocketo.domain.expense.ExpenseRepository
import com.winphyoethu.pocketo.domain.usage.MonthlyUsageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindAccountRepository(accountRepositoryImpl: AccountRepositoryImpl): AccountRepository

    @Binds
    abstract fun bindCategoryRepository(accountRepositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindExpenseRepository(expenseRepositoryImpl: ExpenseRepositoryImpl): ExpenseRepository

    @Binds
    abstract fun bindMonthlyUsageRepository(monthlyUsageRepositoryImpl: MonthlyUsageRepositoryImpl): MonthlyUsageRepository

}