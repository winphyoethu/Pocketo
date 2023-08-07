package com.winphyoethu.pocketo.data.common.expense

import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.exception.ExpenseNotFoundException
import com.winphyoethu.pocketo.domain.expense.ExpenseRepository
import com.winphyoethu.pocketo.domain.expense.model.Expense
import com.winphyoethu.pocketo.domain.toErrorResult
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    val expenseLocalDataSource: ExpenseLocalDataSource
) : ExpenseRepository {

    override suspend fun saveExpense(expense: Expense): Response<Int> {
        try {
            val data = expenseLocalDataSource.saveExpense(expense)

            return Response.OnSuccess(data)
        } catch (e: Exception) {
            return e.toErrorResult()
        }
    }

    override suspend fun deleteExpense(expense: Expense): Response<Int> {
        try {
            val data = expenseLocalDataSource.deleteExpense(expense)

            if (data >= 0) {
                return Response.OnSuccess(data)
            }
            return ExpenseNotFoundException().toErrorResult()
        } catch (e: Exception) {
            return e.toErrorResult()
        }
    }

    override suspend fun updateExpense(expense: Expense): Response<Int> {
        try {
            val data = expenseLocalDataSource.updateExpense(expense)

            return Response.OnSuccess(data)
        } catch (e: Exception) {
            return e.toErrorResult()
        }
    }

}