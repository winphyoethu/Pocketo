package com.winphyoethu.pocketo.domain.account

import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.account.model.Account

interface AccountRepository {

    suspend fun saveAccount(account: Account): Response<Int>

    suspend fun updateAccount(account: Account): Response<Int>

}