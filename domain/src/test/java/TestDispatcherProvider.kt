import com.winphyoethu.pocketo.domain.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import java.util.concurrent.Executors

class TestDispatcherProvider : DispatcherProvider {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun main(): CoroutineDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun io(): CoroutineDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun default(): CoroutineDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun unconfined(): CoroutineDispatcher = StandardTestDispatcher()

}