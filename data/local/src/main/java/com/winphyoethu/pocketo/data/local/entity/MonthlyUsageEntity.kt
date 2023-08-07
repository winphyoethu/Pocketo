package com.winphyoethu.pocketo.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "monthly_usage")
data class MonthlyUsageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "balance")
    val balance: Int,
    @ColumnInfo(name = "used")
    val used: Int,
    @ColumnInfo(name = "month")
    val month: String,
    @ColumnInfo(name = "year")
    val year: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Long,
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long
)