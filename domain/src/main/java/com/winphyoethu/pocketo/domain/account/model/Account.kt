package com.winphyoethu.pocketo.domain.account.model

data class Account(
    val id: Int,
    val name: String,
    val income: String,
    val createdAt: Long,
    val updatedAt: Long
)