package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var repo: TaskRepository) : ViewModel() {


    fun add(task: String){
        CoroutineScope(Dispatchers.Main).launch {
            repo.add(task)


        }

    }

}