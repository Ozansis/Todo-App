package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentDetailBinding
import com.example.todoapp.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {


    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        binding.detailFragment=this


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : DetailViewModel by viewModels()
        viewModel = temp
    }

    fun buttonAdd(task: String){
       viewModel.add(task)

    }


}