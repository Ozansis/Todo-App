package com.example.todoapp.data.datasource

import com.example.todoapp.data.entity.Tasks
import com.example.todoapp.room.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource(var tdao: TaskDao) {


    suspend fun loadTask() : List<Tasks> =
        withContext(Dispatchers.IO){
        return@withContext tdao.loadTask()


    }


    suspend fun search(searchWord: String): List<Tasks> = withContext(Dispatchers.IO){

        return@withContext tdao.search(searchWord)


    }


   suspend fun add(task: String) = withContext(Dispatchers.IO){
      val newTask = Tasks(0,task)
       tdao.add(newTask)

   }


   suspend fun update(id: Int,task: String) = withContext(Dispatchers.IO){
       val newTask = Tasks(id,task)
       tdao.update(newTask)



   }

}