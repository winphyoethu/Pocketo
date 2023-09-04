import com.nhaarman.mockitokotlin2.mock
import com.winphyoethu.pocketo.data.common.usage.MonthlyUsageLocalDataSource
import com.winphyoethu.pocketo.data.common.usage.MonthlyUsageRepositoryImpl
import com.winphyoethu.pocketo.domain.usage.MonthlyUsageRepository
import org.junit.After
import org.junit.Before
import org.junit.Test

class UsageRepositoryTest {

    private var monthlyUsageLocalDataSource: MonthlyUsageLocalDataSource? = null

    private var usageRepository: MonthlyUsageRepository? = null

    @Before
    fun setUp() {
        monthlyUsageLocalDataSource = mock()
        usageRepository = MonthlyUsageRepositoryImpl()
    }

    @After
    fun tearDown() {
        monthlyUsageLocalDataSource = null
        usageRepository = null
    }

    @Test
    fun `Save Monthly Usage Return Success`() {

    }

    @Test
    fun `Save Monthly Usage Return Exception`() {

    }

    @Test
    fun `Update Monthly Usage Return Success`() {

    }

    @Test
    fun `Update Monthly Usage Return Null`() {

    }

    @Test
    fun `Update Monthly Usage Return Exception`() {

    }

}