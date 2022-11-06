package com.solanacode.challangech5.test


import com.google.common.truth.Truth
import com.solanacode.challangech5.utils.SearchUtil
import org.junit.Before
import org.junit.Test

class SearchUtilTest {
    lateinit var search : SearchUtil

    @Before
    fun setup(){
        search = SearchUtil
    }

    @Test
    fun `field is empety or blank` (){
        val validate = search.validateSearch("")
        Truth.assertThat(validate == "success")
    }
}