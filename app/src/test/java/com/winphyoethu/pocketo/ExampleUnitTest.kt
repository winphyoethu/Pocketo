package com.winphyoethu.pocketo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}