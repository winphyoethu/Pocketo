package com.winphyoethu.pocketo.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<I, O> constructor(protected val dispatcherProvider: DispatcherProvider) {

    fun execute(input: I): Flow<O> {
        return provide(input).flowOn(dispatcherProvider.io())
    }

    protected abstract fun provide(input: I): Flow<O>

}