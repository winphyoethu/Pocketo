import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.winphyoethu.pocketo.data.common.account.AccountLocalDataSource
import com.winphyoethu.pocketo.data.common.account.AccountRepositoryImpl
import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.account.AccountRepository
import com.winphyoethu.pocketo.domain.account.model.Account
import com.winphyoethu.pocketo.domain.exception.AccountNotFoundException
import com.winphyoethu.pocketo.domain.toErrorResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AccountRepositoryTest {

    private val accountLocalDataSource = mock<AccountLocalDataSource>()

    private var accountRepository: AccountRepository? = null

    @Before
    fun setUp() {
        accountRepository = AccountRepositoryImpl(accountLocalDataSource)
    }

    @After
    fun tearDown() {
        accountRepository = null
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Save Account Return Successful`() = runTest {
        val account = Account(
            id = 1,
            name = "Win",
            income = "10000",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(accountLocalDataSource.saveAccount(account)).thenReturn(1)

        val response = accountRepository?.saveAccount(account)

        Assert.assertEquals(Response.OnSuccess(1), response)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Save Account Return Exception`() = runTest {
        val account = Account(
            id = 1,
            name = "Win",
            income = "10000",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(accountLocalDataSource.saveAccount(account)).doAnswer { throw Exception("Save Account Exception") }

        val response = accountRepository?.saveAccount(account)

        Assert.assertEquals(Exception("Save Account Exception").toErrorResult<Int>(), response)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Account Return Successful`() = runTest {
        val account = Account(
            id = 1,
            name = "Win",
            income = "10000",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(accountLocalDataSource.updateAccount(account)).thenReturn(1)

        val response = accountRepository?.updateAccount(account)

        Assert.assertEquals(Response.OnSuccess(1), response)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Account Return Null`() = runTest {
        val account = Account(
            id = 1,
            name = "Win",
            income = "10000",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(accountLocalDataSource.updateAccount(account)).thenReturn(-1)

        val response = accountRepository?.updateAccount(account)

        Assert.assertEquals(AccountNotFoundException().toErrorResult<Int>(), response)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Account Return Exception`() = runTest {
        val account = Account(
            id = 1,
            name = "Win",
            income = "10000",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(accountLocalDataSource.updateAccount(account)).doAnswer { throw Exception("Update Account Error") }

        val response = accountRepository?.updateAccount(account)

        Assert.assertEquals(Exception("Update Account Error").toErrorResult<Int>(), response)
    }

}