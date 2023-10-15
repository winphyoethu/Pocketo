package com.winphyoethu.pocketo.data.common.account

import com.winphyoethu.pocketo.domain.account.model.Account

interface AccountLocalDataSource {

    suspend fun saveAccount(account: Account): Long

    suspend fun updateAccount(account: Account): Long

}