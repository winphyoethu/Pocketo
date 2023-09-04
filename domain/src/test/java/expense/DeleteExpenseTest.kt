package expense

import TestDispatcherProvider
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.exception.ExpenseNotFoundException
import com.winphyoethu.pocketo.domain.expense.ExpenseRepository
import com.winphyoethu.pocketo.domain.expense.model.Expense
import com.winphyoethu.pocketo.domain.expense.usecase.DeleteExpense
import com.winphyoethu.pocketo.domain.toErrorResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DeleteExpenseTest {

    private val expenseRepository = mock<ExpenseRepository>()

    private val dispatcherProvider = TestDispatcherProvider()

    private val deleteExpense = DeleteExpense(expenseRepository, dispatcherProvider)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcherProvider.io())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Delete Expense Return Successful`() {
        val expense = Expense(
            id = 1,
            userId = 2,
            expenseTitle = "Rent",
            expenseDescription = "Rent fee for oct",
            expenseAmount = 9000,
            categoryId = 1,
            createdAt = 1L,
            updatedAt = 1L
        )
        runTest {
            whenever(expenseRepository.deleteExpense(expense)).thenReturn(Response.OnSuccess(1))

            val result = deleteExpense.execute(DeleteExpense.Params(expense))
            runCurrent()

            Assert.assertEquals(Response.OnSuccess(1), result)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Delete Expense Return Not Found`() {
        val expense = Expense(
            id = 1,
            userId = 2,
            expenseTitle = "Rent",
            expenseDescription = "Rent fee for oct",
            expenseAmount = 9000,
            categoryId = 1,
            createdAt = 1L,
            updatedAt = 1L
        )
        runTest {
            whenever(expenseRepository.deleteExpense(expense)).thenReturn(ExpenseNotFoundException().toErrorResult())

            launch {
                val result = deleteExpense.execute(DeleteExpense.Params(expense))
                runCurrent()

                Assert.assertEquals(ExpenseNotFoundException().toErrorResult<Int>(), result)
            }
        }
    }

}