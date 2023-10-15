package com.winphyoethu.pocketo.data.local.source

import com.winphyoethu.pocketo.data.common.account.AccountLocalDataSource
import com.winphyoethu.pocketo.data.local.dao.AccountDao
import com.winphyoethu.pocketo.data.local.entity.AccountEntity
import com.winphyoethu.pocketo.domain.account.model.Account

class AccountLocalDataSourceImpl(val accountDao: AccountDao) : AccountLocalDataSource {
    override suspend fun saveAccount(account: Account): Long {
        return accountDao.putAccount(
            AccountEntity(
                name = account.name,
                income = account.income,
                createdAt = account.createdAt,
                updatedAt = account.updatedAt
            )
        )
    }

    override suspend fun updateAccount(account: Account): Long {
        TODO("Not yet implemented")
    }
}