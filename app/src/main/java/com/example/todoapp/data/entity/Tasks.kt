package com.example.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


@Entity(tableName = "tasks")
data class Tasks(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "id")  var id : Int=0,
                 @ColumnInfo(name = "task")  var task: String): Serializable {


}