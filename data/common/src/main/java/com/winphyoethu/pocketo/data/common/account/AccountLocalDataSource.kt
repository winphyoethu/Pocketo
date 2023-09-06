package com.winphyoethu.pocketo.data.common.account

import com.winphyoethu.pocketo.domain.account.model.Account

interface AccountLocalDataSource {

    suspend fun saveAccount(account: Account): Int

    suspend fun updateAccount(account: Account): Int

}