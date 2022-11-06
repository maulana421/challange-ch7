package com.solanacode.challange.fragement

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.solanacode.challange.R
import com.solanacode.challange.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private lateinit var binding : FragmentSplashBinding
    private lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater)
        sharedPref = context?.getSharedPreferences("getdataUser", Context.MODE_PRIVATE)!!
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        throw RuntimeException("Test Crash") // Force a crash
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val id = sharedPref.getString("id","not")
            if(id != "not"){
                Navigation.findNavController(binding.root).navigate(R.id.homeFragment)
            }else{
                Navigation.findNavController(binding.root).navigate(R.id.loginFragment)
            }
        },1000)

    }


}