package com.winphyoethu.pocketo.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.winphyoethu.pocketo.data.local.entity.ExpenseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun putExpense(expense: ExpenseEntity): Int

    @Update
    suspend fun updateExpense(expense: ExpenseEntity): Int

    @Delete
    suspend fun deleteExpense(expense: ExpenseEntity): Int

    @Query("SELECT * FROM expense WHERE user_id = :userId AND created_at > :startDate AND created_at < :endDate")
    fun getExpenseList(userId: Int, startDate: Long, endDate: Long): Flow<List<ExpenseEntity>>

}