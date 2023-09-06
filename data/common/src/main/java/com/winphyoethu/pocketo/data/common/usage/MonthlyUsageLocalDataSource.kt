package com.winphyoethu.pocketo.data.common.usage

import com.winphyoethu.pocketo.domain.usage.model.Usage

interface MonthlyUsageLocalDataSource {

    fun saveMonthlyUsage(usage: Usage): Int

    fun updateMonthlyUsage(usage: Usage): Int

}