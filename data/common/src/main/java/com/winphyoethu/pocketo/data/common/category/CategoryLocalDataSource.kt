package com.winphyoethu.pocketo.data.common.category

import com.winphyoethu.pocketo.domain.category.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryLocalDataSource {

    fun getCategory() : Flow<List<Category>>

}