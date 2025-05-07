package com.example.todoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.todoapp.databinding.FragmentUpdateBinding



class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUpdateBinding.inflate(inflater,container,false)

        val bundle : UpdateFragmentArgs by navArgs()
        val task = bundle.task


        binding.etUpdate.setText(task.task)




        return binding.root
    }


}