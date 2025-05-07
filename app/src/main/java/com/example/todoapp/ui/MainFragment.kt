package com.example.todoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.Task
import com.example.todoapp.databinding.FragmentMainBinding
import com.example.todoapp.ui.adapter.TaskAdapter


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)


        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.detailgecis)


        }

        val taskList = ArrayList<Task>()
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        val task1 = Task(1,"Oku")
        val task2 = Task(2,"Yaz")
        val task3 = Task(3,"Çalış")
        val task4 = Task(4,"Yat")
        taskList.add(task1)
        taskList.add(task2)
        taskList.add(task3)
        taskList.add(task4)

        val adapter = TaskAdapter(requireContext(),taskList)
        binding.rv.adapter = adapter




        return binding.root
    }

}