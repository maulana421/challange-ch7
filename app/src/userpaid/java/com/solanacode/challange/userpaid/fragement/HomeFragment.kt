package com.solanacode.challange.userpaid.fragement

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.solanacode.challange.R
import com.solanacode.challange.databinding.FragmentHomeBinding
import com.solanacode.challange.fragement.HomeFragmentDirections
import com.solanacode.challange.userpaid.adapter.MovieAdapter
import com.solanacode.challangech5.model.ItemResponseItem
import com.solanacode.challangech5.viewmodel.MovieViewModel


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var sharedPref: SharedPreferences
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieViewModel: MovieViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        sharedPref = context?.getSharedPreferences("getdataUser", Context.MODE_PRIVATE)!!
        movieViewModel = ViewModelProvider(requireActivity())[MovieViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMovie()
        showLoading(true)
        binding.ivProfile.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.profileFragment)
        }

        val a = sharedPref.getString("name","not")
        binding.tvPerson.text = a


    }

    fun showMovie(){
        movieAdapter = MovieAdapter(object :MovieAdapter.Clicked{
            override fun onClick(itemResponseItem: ItemResponseItem) {
                val i = HomeFragmentDirections.actionHomeFragmentToDetailMovieFragment(itemResponseItem.id)
                findNavController().navigate(i)
            }

        })
        movieViewModel.showFilmList()
        movieViewModel.getLiveDataFilms().observe(requireActivity()){
            if(it != null){
                movieAdapter.submitData(it)
                showLoading(false)
            }else{
                Toast.makeText(requireActivity(), "Null Blok", Toast.LENGTH_SHORT).show()
            }
        }
        binding.rvMain.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun showLoading(isLoading : Boolean){
        if (isLoading) binding.progressbar.visibility = View.VISIBLE else
            binding.progressbar.visibility = View.GONE
    }

}