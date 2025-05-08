package com.example.todoapp.di

import com.example.todoapp.data.datasource.TaskDataSource
import com.example.todoapp.data.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideTaskDatasource( ): TaskDataSource{

        return TaskDataSource()

    }



    @Provides
    @Singleton
    fun provideTaskRepository(ds: TaskDataSource): TaskRepository{

        return TaskRepository(ds)

    }






}