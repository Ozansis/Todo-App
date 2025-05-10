package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.Tasks
import com.example.todoapp.databinding.TaskCardViewBinding
import com.example.todoapp.ui.fragment.MainFragmentDirections

class TaskAdapter(var context: Context,var taskList: List<Tasks>) : RecyclerView.Adapter<TaskAdapter.CardViewHolder>() {


    inner class CardViewHolder(var view: TaskCardViewBinding): RecyclerView.ViewHolder(view.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = TaskCardViewBinding.inflate(LayoutInflater.from(context),parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val task =taskList.get(position)
        val t = holder.view

        t.textView.text = task.task

        t.cardTask.setOnClickListener {

            val gecis = MainFragmentDirections.updategecis(task = task)
            Navigation.findNavController(it).navigate(gecis)

        }


    }

    override fun getItemCount(): Int {
        return taskList.size
    }





}