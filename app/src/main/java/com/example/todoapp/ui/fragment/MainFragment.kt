package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.Task
import com.example.todoapp.databinding.FragmentMainBinding
import com.example.todoapp.ui.adapter.TaskAdapter
import com.example.todoapp.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main ,container,false)
        binding.mainFragment = this





        binding.srcView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.search(p0)
                return true
            }

            override fun onQueryTextChange(p0: String): Boolean {
                viewModel.search(p0)
                return true
            }


        })

        viewModel.taskList.observe ( viewLifecycleOwner ){

            val adapter = TaskAdapter(requireContext(),it)
            binding.taskAdapter =adapter

        }







        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : MainViewModel by viewModels()
        viewModel = temp
    }

    fun fabTıkla(it: View){
        Navigation.findNavController(it).navigate(R.id.detailgecis)


    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTask()
    }


}