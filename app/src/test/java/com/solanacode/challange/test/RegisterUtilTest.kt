package com.solanacode.challangech5.test


import com.google.common.truth.Truth.assertThat
import com.solanacode.challangech5.utils.RegisterUtils
import org.junit.Before
import org.junit.Test

class RegisterUtilTest {

    lateinit var regist : RegisterUtils

    @Before
    fun setup(){
        regist = RegisterUtils
    }

    @Test
    fun `name is empety`(){
        val validate = regist.validateUserRegister("","","")
        assertThat(validate == "success")
    }

    @Test
    fun `password must containts @`(){
        val validate = regist.validateUserRegister("maulana","maulana","herokucom")
        assertThat(validate == "success")
    }

    @Test
    fun `password must be 6 digit`(){
        val validate = regist.validateUserRegister("maulana","solana@gmail","asd")
        assertThat(validate == "success")
    }
}