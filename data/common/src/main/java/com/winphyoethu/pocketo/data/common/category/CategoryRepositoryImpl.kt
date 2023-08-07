package com.winphyoethu.pocketo.data.common.category

import com.winphyoethu.pocketo.domain.category.CategoryRepository
import com.winphyoethu.pocketo.domain.category.model.Category
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(val categoryLocalDataSource: CategoryLocalDataSource) :
    CategoryRepository {

    override fun getCategory(): Flow<List<Category>> {
        return categoryLocalDataSource.getCategory()
    }

}