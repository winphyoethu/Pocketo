package category

import TestDispatcherProvider
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.winphyoethu.pocketo.domain.category.CategoryRepository
import com.winphyoethu.pocketo.domain.category.model.Category
import com.winphyoethu.pocketo.domain.category.usecase.GetCategory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions
import org.junit.Test

class GetCategoryTest {

    private val categoryRepository = mock<CategoryRepository>()

    private val dispatcherProvider = TestDispatcherProvider()

    private val getCategory: GetCategory by lazy {
        GetCategory(categoryRepository, dispatcherProvider)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getCategoryReturnSuccess() = runBlockingTest {
        val testCategoryList = listOf(
            Category(1, "Housing", 1L, 1L),
            Category(2, "Education", 1L, 1L)
        )
        whenever(categoryRepository.getCategory())
            .thenReturn(flow {
                emit(testCategoryList)
            })

        val categoryList = mutableListOf<Category>()

        getCategory.execute(Unit).collect {
            categoryList.addAll(it)
        }

        Assertions.assertThat(categoryList)
            .containsExactly(Category(1, "Housing", 1L, 1L), Category(2, "Education", 1L, 1L))
    }

}