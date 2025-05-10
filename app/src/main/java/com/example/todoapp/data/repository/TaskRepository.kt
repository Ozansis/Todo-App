package com.example.todoapp.data.repository

import com.example.todoapp.data.datasource.TaskDataSource
import com.example.todoapp.data.entity.Tasks

class TaskRepository(var ds : TaskDataSource) {


    suspend fun add(task: String) = ds.add(task)
    suspend fun loadTask() : List<Tasks> = ds.loadTask()
    suspend fun update(id: Int,task: String) = ds.update(id,task)
    suspend fun search(searchWord: String): List<Tasks> = ds.search(searchWord)


}