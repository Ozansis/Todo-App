package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.Tasks


@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
     fun loadTask(): List<Tasks>


    @Insert
     fun add(task:Tasks)

    @Update
     fun update(task:Tasks)


    @Query("Select * FROM tasks WHERE task LIKE '%' || :searchWord || '%'")
     fun search(searchWord: String) : List<Tasks>

}