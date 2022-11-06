package com.solanacode.challangech5.test


import com.google.common.truth.Truth.assertThat
import com.solanacode.challangech5.utils.CheckUserUtils
import org.junit.Before
import org.junit.Test

class CheckUserTest {

    lateinit var user : CheckUserUtils

    @Before
    fun setup(){
        user = CheckUserUtils
    }

    @Test
    fun `check token not undefined`(){
        val validate = CheckUserUtils.validateUser("undefined")
        assertThat(validate)
    }
}