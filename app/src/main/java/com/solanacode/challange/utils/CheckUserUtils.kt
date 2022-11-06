package com.solanacode.challangech5.utils

object CheckUserUtils {
    fun validateUser(token : String): Boolean{
        if(token.equals("undefined")){
            return false
        }
        return true

    }
}