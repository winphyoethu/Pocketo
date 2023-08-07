package com.winphyoethu.pocketo.domain.category

import com.winphyoethu.pocketo.domain.category.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getCategory(): Flow<List<Category>>

}