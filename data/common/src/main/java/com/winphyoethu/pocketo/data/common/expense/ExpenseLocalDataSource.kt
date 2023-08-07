package com.winphyoethu.pocketo.data.common.expense

import com.winphyoethu.pocketo.domain.expense.model.Expense

interface ExpenseLocalDataSource {

    suspend fun saveExpense(expense: Expense) : Int

    suspend fun deleteExpense(expense: Expense) : Int

    suspend fun updateExpense(expense: Expense) : Int

}