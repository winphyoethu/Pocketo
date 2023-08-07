package com.winphyoethu.pocketo.domain.expense.usecase

import com.winphyoethu.pocketo.domain.CoroutineUseCase
import com.winphyoethu.pocketo.domain.DispatcherProvider
import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.expense.ExpenseRepository
import com.winphyoethu.pocketo.domain.expense.model.Expense
import javax.inject.Inject

class SaveExpense @Inject constructor(
    val expenseRepository: ExpenseRepository,
    dispatcherProvider: DispatcherProvider
) : CoroutineUseCase<SaveExpense.Params, Response<Int>>(dispatcherProvider) {

    data class Params(val expense: Expense)

    override suspend fun provide(input: Params): Response<Int> {
        return expenseRepository.saveExpense(input.expense)
    }

}