package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.Tasks
import com.example.todoapp.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var repo: TaskRepository) : ViewModel() {

    val taskList = MutableLiveData<List<Tasks>>()


    init {
        loadTask()
    }

     fun search(searchWord: String){
         CoroutineScope(Dispatchers.Main).launch {

             taskList.value = repo.search(searchWord)

         }



     }
    fun loadTask() {
        CoroutineScope(Dispatchers.Main).launch {

            taskList.value = repo.loadTask()

        }

    }




}