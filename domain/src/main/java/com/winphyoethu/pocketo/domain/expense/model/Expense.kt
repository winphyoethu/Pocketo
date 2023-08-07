package com.winphyoethu.pocketo.domain.expense.model

data class Expense(
    val id: Int,
    val userId: Int,
    val expenseTitle: String,
    val expenseDescription: String?,
    val expenseAmount: Int,
    val categoryId: Int,
    val createdAt: Long,
    val updatedAt: Long
)