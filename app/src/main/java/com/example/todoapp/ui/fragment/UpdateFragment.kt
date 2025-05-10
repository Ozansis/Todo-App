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
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentUpdateBinding
import com.example.todoapp.ui.viewmodel.DetailViewModel
import com.example.todoapp.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private lateinit var viewModel: UpdateViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_update,container,false)

        val bundle : UpdateFragmentArgs by navArgs()
        val task = bundle.task
        binding.updateFragment = this
        binding.taskNesnesi = task



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : UpdateViewModel by viewModels()
        viewModel = temp
    }


    fun buttonUpdateTask(id: Int,task: String,view: View){
       viewModel.update(id,task)
        Navigation.findNavController(view).navigate(R.id.update_to_main)


    }


}