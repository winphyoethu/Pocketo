package com.winphyoethu.pocketo.domain.expense

import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.expense.model.Expense

interface ExpenseRepository {

    suspend fun saveExpense(expense: Expense): Response<Int>

    suspend fun deleteExpense(expense: Expense): Response<Int>

    suspend fun updateExpense(expense: Expense): Response<Int>

}