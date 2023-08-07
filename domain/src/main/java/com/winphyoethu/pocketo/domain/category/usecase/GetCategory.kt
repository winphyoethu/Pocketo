package com.winphyoethu.pocketo.domain.category.usecase

import com.winphyoethu.pocketo.domain.CoroutineUseCase
import com.winphyoethu.pocketo.domain.DispatcherProvider
import com.winphyoethu.pocketo.domain.FlowUseCase
import com.winphyoethu.pocketo.domain.category.CategoryRepository
import com.winphyoethu.pocketo.domain.category.model.Category
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategory @Inject constructor(
    val categoryRepository: CategoryRepository,
    dispatcherProvider: DispatcherProvider
) :
    FlowUseCase<Unit, List<Category>>(dispatcherProvider) {

    override fun provide(input: Unit): Flow<List<Category>> {
        return categoryRepository.getCategory()
    }

}