package com.example.expensetracker.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.expensetracker.models.Person
import com.example.expensetracker.repository.expenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(private val repository: expenseRepository):  ViewModel() {

        val users : StateFlow<List<Person>>
            get() = repository.userData

    var isInputActive by mutableStateOf(false)
            private set
        fun showPopup(){
            isInputActive = true
            Log.d("expenseViewModel", "isInputActive set to $isInputActive true")
        }
        fun dismissPopup(){
            isInputActive = false
            Log.d("expenseViewModel", "isInputActive set to false")

        }
        var expenseList = mutableStateOf(listOf<String>())

        fun addExpense(newExpense: String) {
            val currentList = expenseList.value.toMutableList()

            currentList.add(newExpense)

            expenseList.value = currentList.toList()
        }

}