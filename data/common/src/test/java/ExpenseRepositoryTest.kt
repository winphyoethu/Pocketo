import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.winphyoethu.pocketo.data.common.expense.ExpenseLocalDataSource
import com.winphyoethu.pocketo.data.common.expense.ExpenseRepositoryImpl
import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.exception.ExpenseNotFoundException
import com.winphyoethu.pocketo.domain.expense.model.Expense
import com.winphyoethu.pocketo.domain.toErrorResult
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

class ExpenseRepositoryTest {

    private val expenseLocalDataSource = mock<ExpenseLocalDataSource>()

    private val expenseRepository = ExpenseRepositoryImpl(expenseLocalDataSource)

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
        runBlockingTest {
            whenever(expenseLocalDataSource.deleteExpense(expense)).thenReturn(-1)

            val result = expenseRepository.deleteExpense(expense)

            Assert.assertEquals(Response.OnSuccess(-1), result)
        }
    }

}