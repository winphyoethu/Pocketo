package com.winphyoethu.pocketo.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.winphyoethu.pocketo.data.local.entity.MonthlyUsageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MonthlyUsageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun putMonthlyUsage(monthlyUsage: MonthlyUsageEntity)

    @Update
    suspend fun updateMonthlyUsage(monthlyUsage: MonthlyUsageEntity)

    @Delete
    suspend fun deleteMonthlyUsage(monthlyUsage: MonthlyUsageEntity)

    @Query("SELECT * FROM monthly_usage WHERE user_id = :userId AND created_at > :startDate AND created_at < :endDate")
    fun getMonthlyUsage(userId: Int, startDate: Long, endDate: Long): Flow<MonthlyUsageEntity>

}