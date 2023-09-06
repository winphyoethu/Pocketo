import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.winphyoethu.pocketo.data.common.usage.MonthlyUsageLocalDataSource
import com.winphyoethu.pocketo.data.common.usage.MonthlyUsageRepositoryImpl
import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.exception.UsageNotFoundException
import com.winphyoethu.pocketo.domain.toErrorResult
import com.winphyoethu.pocketo.domain.usage.MonthlyUsageRepository
import com.winphyoethu.pocketo.domain.usage.model.Usage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UsageRepositoryTest {

    private var monthlyUsageLocalDataSource = mock<MonthlyUsageLocalDataSource>()

    private var usageRepository: MonthlyUsageRepository? = null

    @Before
    fun setUp() {
        usageRepository = MonthlyUsageRepositoryImpl(monthlyUsageLocalDataSource)
    }

    @After
    fun tearDown() {
        usageRepository = null
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Save Monthly Usage Return Success`() = runTest {
        val usage = Usage(
            id = 1,
            userId = 1,
            balance = 1000,
            used = 5000,
            month = "Jan",
            year = "2023",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(monthlyUsageLocalDataSource.saveMonthlyUsage(usage)).thenReturn(1)

        val response = usageRepository?.saveMonthlyUsage(usage)

        Assert.assertEquals(Response.OnSuccess(1), response)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Save Monthly Usage Return Exception`() = runTest {
        val usage = Usage(
            id = 1,
            userId = 1,
            balance = 1000,
            used = 5000,
            month = "Jan",
            year = "2023",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(monthlyUsageLocalDataSource.saveMonthlyUsage(usage)).doAnswer { throw Exception("Save Usage Error") }

        val response = usageRepository?.saveMonthlyUsage(usage)

        Assert.assertEquals(Exception("Save Usage Error").toErrorResult<Int>(), response)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Monthly Usage Return Success`() = runTest {
        val usage = Usage(
            id = 1,
            userId = 1,
            balance = 1000,
            used = 5000,
            month = "Jan",
            year = "2023",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(monthlyUsageLocalDataSource.updateMonthlyUsage(usage)).thenReturn(1)

        val response = usageRepository?.updateMonthlyUsage(usage)

        Assert.assertEquals(Response.OnSuccess(1), response)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Monthly Usage Return Null`() = runTest {
        val usage = Usage(
            id = 1,
            userId = 1,
            balance = 1000,
            used = 5000,
            month = "Jan",
            year = "2023",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(monthlyUsageLocalDataSource.updateMonthlyUsage(usage)).thenReturn(-1)

        val response = usageRepository?.updateMonthlyUsage(usage)

        Assert.assertEquals(UsageNotFoundException().toErrorResult<Int>(), response)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Update Monthly Usage Return Exception`() = runTest {
        val usage = Usage(
            id = 1,
            userId = 1,
            balance = 1000,
            used = 5000,
            month = "Jan",
            year = "2023",
            createdAt = 0L,
            updatedAt = 0L
        )
        whenever(monthlyUsageLocalDataSource.updateMonthlyUsage(usage)).thenAnswer {
            throw Exception(
                "Error"
            )
        }

        val response = usageRepository?.updateMonthlyUsage(usage)

        Assert.assertEquals(Exception("Error").toErrorResult<Int>(), response)
    }

}