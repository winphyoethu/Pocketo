package com.winphyoethu.pocketo.data.local.source

import com.winphyoethu.pocketo.data.common.expense.ExpenseLocalDataSource
import com.winphyoethu.pocketo.data.local.dao.ExpenseDao
import com.winphyoethu.pocketo.data.local.entity.ExpenseEntity
import com.winphyoethu.pocketo.domain.expense.model.Expense
import javax.inject.Inject

class ExpenseLocalDataSourceImpl @Inject constructor(val expenseDao: ExpenseDao) :
    ExpenseLocalDataSource {

    override suspend fun saveExpense(expense: Expense): Long {
        return expenseDao.putExpense(
            ExpenseEntity(
                userId = expense.userId,
                expenseTitle = expense.expenseTitle,
                expenseDescription = expense.expenseDescription,
                expenseAmount = expense.expenseAmount,
                categoryId = expense.categoryId,
                createdAt = expense.createdAt,
                updatedAt = expense.updatedAt
            )
        )
    }

    override suspend fun deleteExpense(expense: Expense): Int {
        return expenseDao.deleteExpense(
            ExpenseEntity(
                id = expense.id,
                userId = expense.userId,
                expenseTitle = expense.expenseTitle,
                expenseDescription = expense.expenseDescription,
                expenseAmount = expense.expenseAmount,
                categoryId = expense.categoryId,
                createdAt = expense.createdAt,
                updatedAt = expense.updatedAt
            )
        )
    }

    override suspend fun updateExpense(expense: Expense): Int {
        return expenseDao.updateExpense(
            ExpenseEntity(
                id = expense.id,
                userId = expense.userId,
                expenseTitle = expense.expenseTitle,
                expenseDescription = expense.expenseDescription,
                expenseAmount = expense.expenseAmount,
                categoryId = expense.categoryId,
                createdAt = expense.createdAt,
                updatedAt = expense.updatedAt
            )
        )
    }

}