package com.winphyoethu.pocketo.data.local.source

import com.winphyoethu.pocketo.data.common.category.CategoryLocalDataSource
import com.winphyoethu.pocketo.data.local.dao.CategoryDao
import com.winphyoethu.pocketo.domain.category.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryLocalDataSourceImpl @Inject constructor(val categoryDao: CategoryDao) :
    CategoryLocalDataSource {

    override fun getCategory(): Flow<List<Category>> = categoryDao.getCategory().map {
        it.map { entity ->
            entity.mapToCategory()
        }
    }

}