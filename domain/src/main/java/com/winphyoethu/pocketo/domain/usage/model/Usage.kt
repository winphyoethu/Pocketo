package com.winphyoethu.pocketo.domain.usage.model

data class Usage(
    val id: Int,
    val userId: Int,
    val balance: Int,
    val used: Int,
    val createdAt: Long,
    val updatedAt: Long
)