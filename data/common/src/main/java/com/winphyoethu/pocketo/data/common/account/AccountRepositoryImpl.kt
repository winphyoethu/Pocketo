package com.winphyoethu.pocketo.data.common.account

import com.winphyoethu.pocketo.domain.Response
import com.winphyoethu.pocketo.domain.account.AccountRepository
import com.winphyoethu.pocketo.domain.account.model.Account
import com.winphyoethu.pocketo.domain.exception.AccountNotFoundException
import com.winphyoethu.pocketo.domain.toErrorResult
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(val accountLocalDataSource: AccountLocalDataSource) :
    AccountRepository {

    override suspend fun saveAccount(account: Account): Response<Int> {
        try {
            val data = accountLocalDataSource.saveAccount(account)

            return Response.OnSuccess(data)
        } catch (e: Exception) {
            return e.toErrorResult()
        }
    }

    override suspend fun updateAccount(account: Account): Response<Int> {
        try {
            val data = accountLocalDataSource.updateAccount(account)

            if (data >= 0) {
                return Response.OnSuccess(data)
            }

            return AccountNotFoundException().toErrorResult()
        } catch (e: Exception) {
            return e.toErrorResult()
        }
    }

}