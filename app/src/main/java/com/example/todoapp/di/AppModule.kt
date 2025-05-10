package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.TaskDataSource
import com.example.todoapp.data.repository.TaskRepository
import com.example.todoapp.room.Database
import com.example.todoapp.room.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideTaskDatasource( tdao: TaskDao): TaskDataSource{

        return TaskDataSource(tdao)

    }



    @Provides
    @Singleton
    fun provideTaskRepository(ds: TaskDataSource): TaskRepository{

        return TaskRepository(ds)

    }


    @Provides
    @Singleton
    fun providesTaskDao(@ApplicationContext context: Context) : TaskDao{
       val vt = Room.databaseBuilder(context, Database::class.java,"todo.sqlite")
           .createFromAsset("todo.sqlite").build()
        return vt.getTaskDao()


    }






}