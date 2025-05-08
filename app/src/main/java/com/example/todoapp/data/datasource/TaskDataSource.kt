package com.example.todoapp.data.datasource

import android.util.Log
import com.example.todoapp.data.entity.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource {


    suspend fun loadTask() : List<Task> = withContext(Dispatchers.IO){

        val taskList = ArrayList<Task>()
        val task1 = Task(1,"Oku")
        val task2 = Task(2,"Yaz")
        val task3 = Task(3,"Çalış")
        val task4 = Task(4,"Yat")
        taskList.add(task1)
        taskList.add(task2)
        taskList.add(task3)
        taskList.add(task4)

        return@withContext taskList


    }


    suspend fun search(searchWord: String): List<Task> = withContext(Dispatchers.IO){
        Log.e("Search task",searchWord)
        val taskList = ArrayList<Task>()
        val task1 = Task(1,"Oku")
        taskList.add(task1)

        return@withContext taskList


    }


   suspend fun add(task: String){
        Log.e("ekle",task)

   }


   suspend fun update(id: Int,task: String){
        Log.e("x","${id},${task}")


   }

}