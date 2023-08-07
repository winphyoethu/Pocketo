package com.winphyoethu.pocketo.domain

import kotlinx.coroutines.withContext

abstract class CoroutineUseCase<I, O> constructor(protected val dispatcherProvider: DispatcherProvider) {

    suspend fun execute(input: I): O {
        return withContext(dispatcherProvider.io()) {
            provide(input)
        }
    }

    protected abstract suspend fun provide(input: I): O

}