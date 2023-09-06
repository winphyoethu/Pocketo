package com.winphyoethu.pocketo.data.common.usage

import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.exception.UsageNotFoundException
import com.winphyoethu.pocketo.domain.toErrorResult
import com.winphyoethu.pocketo.domain.usage.MonthlyUsageRepository
import com.winphyoethu.pocketo.domain.usage.model.Usage
import javax.inject.Inject

class MonthlyUsageRepositoryImpl @Inject constructor(val monthlyUsageLocalDataSource: MonthlyUsageLocalDataSource) :
    MonthlyUsageRepository {
    override suspend fun saveMonthlyUsage(monthlyUsage: Usage): Response<Int> {
        try {
            val data = monthlyUsageLocalDataSource.saveMonthlyUsage(monthlyUsage)

            return Response.OnSuccess(data)
        } catch (e: Exception) {
            return e.toErrorResult()
        }
    }

    override suspend fun updateMonthlyUsage(monthlyUsage: Usage): Response<Int> {
        try {
            val data = monthlyUsageLocalDataSource.updateMonthlyUsage(monthlyUsage)

            if (data >= 0) {
                return Response.OnSuccess(data)
            }
            return UsageNotFoundException().toErrorResult()
        } catch (e: Exception) {
            return e.toErrorResult()
        }
    }
}