import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.winphyoethu.pocketo.data.common.expense.ExpenseLocalDataSource
import com.winphyoethu.pocketo.data.common.expense.ExpenseRepositoryImpl
import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.exception.ExpenseNotFoundException
import com.winphyoethu.pocketo.domain.expense.model.Expense
import com.winphyoethu.pocketo.domain.toErrorResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ExpenseRepositoryTest {

    private val expenseLocalDataSource = mock<ExpenseLocalDataSource>()

    private val expenseRepository = ExpenseRepositoryImpl(expenseLocalDataSource)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Delete Repository Return Null`() {
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
            whenever(expenseLocalDataSource.deleteExpense(expense)).thenReturn(-1)

            val result = expenseRepository.deleteExpense(expense)

            Assert.assertEquals(ExpenseNotFoundException().toErrorResult<Int>(), result)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Delete Expense Return Success`() {
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
            whenever(expenseLocalDataSource.deleteExpense(expense)).thenReturn(1)

            val result = expenseRepository.deleteExpense(expense)

            Assert.assertEquals(Response.OnSuccess(1), result)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Delete Expense Return Exception`() {
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
            whenever(expenseLocalDataSource.deleteExpense(expense)).doAnswer { throw Exception("Error") }

            val result = expenseRepository.deleteExpense(expense)

            Assert.assertEquals(Exception("Error").toErrorResult<Int>(), result)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Save Expense Return Success`() {
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
            whenever(expenseLocalDataSource.saveExpense(expense)).thenReturn(1)

            val result = expenseRepository.saveExpense(expense)

            Assert.assertEquals(Response.OnSuccess(1), result)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Save Expense Return Exception`() {
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
            whenever(expenseLocalDataSource.saveExpense(expense)).doAnswer { throw Exception("Save Error") }

            val result = expenseRepository.saveExpense(expense)

            Assert.assertEquals(Exception("Save Error").toErrorResult<Int>(), result)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Expense Return Success`() {
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
            whenever(expenseLocalDataSource.updateExpense(expense)).thenReturn(1)

            val result = expenseRepository.updateExpense(expense)

            Assert.assertEquals(Response.OnSuccess(1), result)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Expense Return Exception`() {
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
            whenever(expenseLocalDataSource.updateExpense(expense)).doAnswer { throw Exception("Update Error") }

            val result = expenseRepository.updateExpense(expense)

            Assert.assertEquals(Exception("update Error").toErrorResult<Int>(), result)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Expense Return Not Found`() {
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
            whenever(expenseLocalDataSource.updateExpense(expense)).thenReturn(-1)

            val result = expenseRepository.updateExpense(expense)

            Assert.assertEquals(ExpenseNotFoundException().toErrorResult<Int>(), result)
        }
    }

}