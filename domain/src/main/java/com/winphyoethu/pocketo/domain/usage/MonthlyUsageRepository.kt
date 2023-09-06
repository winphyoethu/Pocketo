package com.winphyoethu.pocketo.domain.usage

import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.usage.model.Usage

interface MonthlyUsageRepository {

    suspend fun saveMonthlyUsage(monthlyUsage: Usage): Response<Int>

    suspend fun updateMonthlyUsage(monthlyUsage: Usage): Response<Int>

}