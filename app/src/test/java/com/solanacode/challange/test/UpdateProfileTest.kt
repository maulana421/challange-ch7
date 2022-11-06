package com.solanacode.challangech5.test


import com.google.common.truth.Truth.assertThat
import com.solanacode.challangech5.utils.UpdateProfile
import org.junit.Before
import org.junit.Test

class UpdateProfileTest {

    lateinit var updateProfile : UpdateProfile

    @Before
    fun setup(){
        updateProfile = UpdateProfile
    }



    @Test
    fun `field is empety or blank` (){
        val validate = updateProfile.validateEditProfile(""," ")
        assertThat(validate == "success")
    }
}